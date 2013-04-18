package mingh.research.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mingh.research.io.util.IRPropertyBean;
import mingh.research.io.util.JaguarOptimizationStepBean;
import mingh.research.io.util.JaguarPropertyBean;
import mingh.research.io.util.JaguarResultBean;
import mingh.research.io.util.Vector3d;

public class ReadJaguarOut {
	
	private JaguarResultBean jaguarResultBean;
	
	private Path rootPath;
	
	private Path outFile;
		
	public static void main(String[] args){
		//test
		JaguarResultBean jaguarResultBean = new JaguarResultBean();
		String outFile = "/media/muffintin0/Elements/Research/DOE/Bimetallic/Store/Bimetallic/13/CoCuGO/CH/17-cocu-ch-a1b2-gs-nc-1.out";
		Path rootPath = Paths.get("/media/muffintin0/Elements/Research/DOE/Bimetallic/Store"); // for construct relative path
		ReadJaguarOut testRead = new ReadJaguarOut(outFile, jaguarResultBean, rootPath);
		System.out.print(testRead);
		
	}
	
	public ReadJaguarOut() {}
	
	// for test
	public ReadJaguarOut(String path, JaguarResultBean jaguarResultBean, Path rootPath){
		this.jaguarResultBean = jaguarResultBean;
		this.outFile = Paths.get(path);
		this.rootPath = rootPath;
		
		try {
			List<String> lines = Files.readAllLines(this.outFile, StandardCharsets.UTF_8);
			parseLines(lines);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// main constructor
	public ReadJaguarOut(Path outFile, JaguarResultBean jaguarResultBean, Path rootPath){
		this.jaguarResultBean = jaguarResultBean;
		this.outFile = outFile;
		this.rootPath = rootPath;
		
		try {
			List<String> lines = Files.readAllLines(this.outFile, StandardCharsets.UTF_8);
			parseLines(lines);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return jaguarResultBean.toString();
	}
	
	private void collectJobResource(String line) {
		if ( line.contains("wallclock:") ){
			double clockTime = Double.parseDouble(line.trim().split("\\s+")[6]); 
			this.jaguarResultBean.addToJobRunTime(clockTime);
		} else if ( line.contains("Peak memory usage:") ) {
			int memory = Integer.parseInt(line.trim().split("\\s+")[3]);
			this.jaguarResultBean.setJobMemory(memory);
		}
	}
	
	private void parseLines(List<String> lines){
		int i = 0;
		boolean findCpu = false;
		int totalLines = lines.size();
		while ( i < totalLines ){ //search the entire document
			
			if (!findCpu){ //get cpu
				if ( lines.get(i).contains("Running on") ){
					int cpus = Integer.parseInt(lines.get(i).trim().split("\\s+")[2]);
					this.jaguarResultBean.setJobCpus(cpus);
					findCpu = true;
				} 
			}
			
			collectJobResource(lines.get(i));
			
			// get the optimization step section
			if ( lines.get(i).contains("(N)  Total energy") ){
				int j = i+1;
				while ( j < i+500 && j < totalLines ) { //search subsequent 500 lines for a step
					if ( lines.get(j).contains("end of geometry optimization iteration") ){
						List<String> optimizationStepLines = lines.subList(i, j); //get the piece for each step
						parseOptimizationStepLines(optimizationStepLines);
						i = j; //skip the parsed part
						break; //finish parse the step
					}
					j++;
				}
			}
			
			// get the freq section
			if ( lines.get(i).contains("start of program freq") ){
				int j = i +1;
				while ( j< i+ 2000 && j < totalLines) { //search 2000 lines for ir section, should be enough
					if ( lines.get(j).contains("end of program freq") ){
						//when we have IR but no optimization step, it may be a SP calculation. 
						//Which is the optimization step without force and geometry
						if (this.jaguarResultBean.getOptimizationSteps().isEmpty()){
							parseLinesForSPCalculation(lines);
						}
						
						List<String> freqLines = lines.subList(i, j);
						parseFreqLines(freqLines);
						i = j; // skip the parsed part
						break; //finish parse the freq section
					}
					j++;
				}
			}
			
			i++;
		}
	}

	private void parseLinesForSPCalculation(List<String> lines){
		int i = 0;
		int totalLines = lines.size();
		while ( i < totalLines ){ //search the entire document
			
			// get the optimization step section
			if ( lines.get(i).contains("(N)  Total energy") ){
				int j = i+1;
				while ( j < i+500 && j < totalLines ) { //search subsequent 500 lines for a step
					if ( lines.get(j).contains("end of program scf") ){
						List<String> optimizationStepLines = lines.subList(i, j); //get the piece for each step
						parseOptimizationStepLines(optimizationStepLines);
						i = j; //skip the parsed part
						break; //finish parse the step
					}
					j++;
				}
			}
			i++;
		}
	}
	
	private void parseOptimizationStepLines(List<String> optimizationStepLines) {
		JaguarOptimizationStepBean jaguarOptimizationStepBean = new JaguarOptimizationStepBean();
		jaguarOptimizationStepBean.setRelativeFilePath(this.rootPath.relativize(this.outFile).toString());
		
		int counter = 0; //for get several lines
		
		while ( counter < optimizationStepLines.size() ){
			String line = optimizationStepLines.get(counter);
			collectJobResource(line);
			if ( line.contains("(N)  Total energy") ) {
				String[] fragments = line.trim().split("\\s+");
				jaguarOptimizationStepBean.setTotalEnergy(Double.parseDouble(fragments[3])); //get total enegy
			} else if (line.contains("Alpha HOMO energy:")) {
				jaguarOptimizationStepBean.setAlphaHOMO(Double.parseDouble(line.trim().split("\\s+")[3])); // alpha HOMO
			} else if (line.contains("Alpha LUMO energy:")) {
				jaguarOptimizationStepBean.setAlphaLUMO(Double.parseDouble(line.trim().split("\\s+")[3])); // alpha LUMO
			} else if (line.contains("Alpha Orbital energies")){ //alpha orbital
				counter++;
				List<Double> alphaOrbital = new ArrayList<Double>();
				while ( !optimizationStepLines.get(counter).trim().isEmpty() ){
					String[] orbitalEnergies = optimizationStepLines.get(counter).trim().split("\\s+");
					for (String energy : orbitalEnergies){
						alphaOrbital.add(Double.parseDouble(energy));
					}
					counter++;
				}
				jaguarOptimizationStepBean.setAlphaOrbital(alphaOrbital);
			} else if (line.contains("Beta HOMO energy:")) {
				jaguarOptimizationStepBean.setBetaHOMO(Double.parseDouble(line.trim().split("\\s+")[3])); // beta HOMO
			} else if (line.contains("Beta LUMO energy:")) {
				jaguarOptimizationStepBean.setBetaLUMO(Double.parseDouble(line.trim().split("\\s+")[3])); // beta LUMO
			} else if (line.contains("Beta Orbital energies")){ //beta orbital
				counter ++;
				List<Double> betaOrbital = new ArrayList<Double>();
				while ( !optimizationStepLines.get(counter).trim().isEmpty() ){
					String[] orbitalEnergies = optimizationStepLines.get(counter).trim().split("\\s+");
					for (String energy : orbitalEnergies){
						betaOrbital.add(Double.parseDouble(energy));
					}
					counter++;
				}
				jaguarOptimizationStepBean.setBetaOrbital(betaOrbital);
			} else if (line.contains("<S**2> ...")) {
				jaguarOptimizationStepBean.setUnrestrictedSpinReal(Double.parseDouble(line.trim().split("\\s+")[2])); //spin
			}else if (line.contains("Sz*(Sz+1)")) {
				jaguarOptimizationStepBean.setUnrestrictedSpinGuess(Double.parseDouble(line.trim().split("\\s+")[1])); //spin
			} else if (line.contains("forces (hartrees/bohr) : total")) {
				counter+= 4; //forces lines 
				List<Vector3d> forces = new ArrayList<Vector3d>();
				while ( true ){
					String forceLine = optimizationStepLines.get(counter);
					if ( forceLine.contains("---") ) {
						counter++;
						forceLine = optimizationStepLines.get(counter); //the total force 
						String[] items = forceLine.trim().split("\\s+");
						Vector3d force = new Vector3d("total",Double.parseDouble(items[1]), Double.parseDouble(items[2]), 
								Double.parseDouble(items[3]));
						forces.add(force);
						break; //finished parse the forces
					}
					String[] items = forceLine.trim().split("\\s+");
					int atomNameIndex = 0;
					while (Character.isLetter(items[1].charAt(atomNameIndex))) atomNameIndex++;
					String atom = items[1].substring(0,atomNameIndex);
					Vector3d force = new Vector3d(atom, Double.parseDouble(items[2]), Double.parseDouble(items[3]), 
							Double.parseDouble(items[4]));
					forces.add(force);
					counter++;
				}
				jaguarOptimizationStepBean.setForces(forces);
				jaguarOptimizationStepBean.setTotalForce(forces.get(forces.size()-1));
			}  else if (line.contains("new geometry:") || line.contains("final geometry:")) {
				counter+= 3; //geometry lines 
				List<Vector3d> xyzs = new ArrayList<Vector3d>();
				while ( !optimizationStepLines.get(counter).trim().isEmpty() ){
					String xyzLine = optimizationStepLines.get(counter);
					String[] items = xyzLine.trim().split("\\s+");
					int atomNameIndex = 0;
					while (Character.isLetter(items[0].charAt(atomNameIndex))) atomNameIndex++;
					String atom = items[0].substring(0,atomNameIndex);
					Vector3d xyz = new Vector3d(atom, Double.parseDouble(items[1]), Double.parseDouble(items[2]), 
							Double.parseDouble(items[3]));
					xyzs.add(xyz);
					counter++;
				}
				jaguarOptimizationStepBean.setXyzs(xyzs);
			}			
			counter ++;
		}
		List<JaguarOptimizationStepBean> optimizationStepBeans = this.jaguarResultBean.getOptimizationSteps();
		optimizationStepBeans.add(jaguarOptimizationStepBean);
		this.jaguarResultBean.setOptimizationSteps(optimizationStepBeans);
	}
	
	private void parseFreqLines(List<String> freqLines) {
		IRPropertyBean irBean = new IRPropertyBean();
		List<Double> frequencies = new ArrayList<Double>();
		List<Double> intensities = new ArrayList<Double>();
		List< List<Vector3d> > normModes = new ArrayList< List<Vector3d> >();
		
		int totalLines = freqLines.size();
		int i = 0;
		
		while ( i< totalLines ){
			if ( freqLines.get(i).contains("frequencies") ){
				String[] numberParts = freqLines.get(i).trim().split("\\s+");
				if ( numberParts[0].equals("frequencies") ){
					int freqNumberCounter = 1;
					String[] intensityParts = freqLines.get(i+1).trim().split("\\s+");
					while (freqNumberCounter < numberParts.length){
						frequencies.add(Double.parseDouble(numberParts[freqNumberCounter]));
						intensities.add(Double.parseDouble(intensityParts[freqNumberCounter]));
						freqNumberCounter++;
					}
					int j = i + 4;
					List<String[]> normModeMatrix = new ArrayList<String[]>();
					while( !freqLines.get(j).trim().isEmpty() ){
						String[] normalModeParts = freqLines.get(j).trim().split("\\s+");
						normModeMatrix.add(normalModeParts);
						j++;
					}
					i = j;
					int normModeNum = normModeMatrix.get(0).length;
					for (int counter = 2; counter <normModeNum; counter++){
						List<Vector3d> normMode = new ArrayList<Vector3d>();
						for (int atomIndex = 0; atomIndex < normModeMatrix.size(); atomIndex +=3 ){
							int atomNameIndex = 0;
							while (Character.isLetter(normModeMatrix.get(atomIndex)[0].charAt(atomNameIndex))) atomNameIndex++;
							String atom = normModeMatrix.get(atomIndex)[0].substring(0,atomNameIndex);
							double x = Double.parseDouble(normModeMatrix.get(atomIndex)[counter]);
							double y = Double.parseDouble(normModeMatrix.get(atomIndex+1)[counter]);
							double z = Double.parseDouble(normModeMatrix.get(atomIndex+2)[counter]);
							Vector3d atomNormMode = new Vector3d(atom, x, y, z);
							normMode.add(atomNormMode);
						}
						normModes.add(normMode);
					}
				}
			} else if ( freqLines.get(i).contains("T =") ){
				irBean.setTemperature(Double.parseDouble(freqLines.get(i).trim().split("\\s+")[2]));
			} else if ( freqLines.get(i).contains("trans.") && freqLines.get(i+1).contains("rot.")){
				String[] parts = freqLines.get(i+4).trim().split("\\s+");
				irBean.setU(Double.parseDouble(parts[1]));
				irBean.setCv(Double.parseDouble(parts[2]));
				irBean.setS(Double.parseDouble(parts[3]));
				irBean.setH(Double.parseDouble(parts[4]));
				irBean.setG(Double.parseDouble(parts[5]));
			} else if ( freqLines.get(i).contains("Total internal energy") ){
				String[] parts = freqLines.get(i).trim().split("\\s+");
				irBean.setInternalEnergy(Double.parseDouble(parts[parts.length-2]));
			} else if ( freqLines.get(i).contains("Total enthalpy") ){
				String[] parts = freqLines.get(i).trim().split("\\s+");
				irBean.setEnthalpy(Double.parseDouble(parts[parts.length-2]));
			} else if ( freqLines.get(i).contains("Total Gibbs free energy") ){
				String[] parts = freqLines.get(i).trim().split("\\s+");
				irBean.setGibbsEnergy(Double.parseDouble(parts[parts.length-2]));
			} else if ( freqLines.get(i).contains("The zero point energy (ZPE):") ){
				String[] parts = freqLines.get(i).trim().split("\\s+");
				irBean.setZPE(Double.parseDouble(parts[parts.length-2]));
			}
			i++;
		}
		irBean.setFrequencyNumbers(frequencies);
		irBean.setIntensities(intensities);
		irBean.setNormalModes(normModes);
		this.jaguarResultBean.setJaguarPropertyBean(irBean);
	}

}
