package mingh.research.io;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.io.FilenameUtils;
import org.springframework.util.StringUtils;

import mingh.research.io.util.JaguarFileBean;
import mingh.research.io.util.JaguarOptimizationStepBean;
import mingh.research.io.util.JaguarResultBean;
import mingh.research.model.GSFCJob;
import mingh.research.model.GSFCJobStep;
import mingh.research.model.GSFCOptimizationProcess;
import mingh.research.model.JobResource;
import mingh.research.model.ReactionSiteTypeEnum;
import mingh.research.model.GSFCStoredFiles;

public class PersistJaguarGSFCJob implements PersistJaguarJob {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Path dirPath = Paths.get("/media/muffintin0/Elements/Research/DOE/Bimetallic/Store/Bimetallic/13/CoCu");
	}

	public void persist(String jobname, JaguarResultBean jaguarResultBean){
//		if ( GSFCJob.findGSFCJobsByUniqueNameEquals(jobname).getResultList().size() == 1 ){
//			System.out.println("Record exists. Skip it.");
//			return;
//		}
		GSFCJob gsfcJob = GSFCJob.findGSFCJobsByUniqueNameEquals(jobname).getResultList().get(0);
		
		System.out.println(jobname);
		
		List<JaguarOptimizationStepBean> optimizationSteps = jaguarResultBean.getOptimizationSteps();
		JaguarOptimizationStepBean lastOptimizationStep = optimizationSteps.get(optimizationSteps.size()-1);
		String[] fragments = jobname.split("-");
		int spin = Integer.parseInt(fragments[0]);
		String cluster = fragments[1];
		String molecule = fragments[2];
		String site = fragments[3];
		
		ReactionSiteTypeEnum siteType =ReactionSiteTypeEnum.valueOf(site);
		
		//create job entry
		GSFCJob jobSummary = new GSFCJob();
		//from job name
		jobSummary.setUniqueName(jobname);
		jobSummary.setSpin(spin);
		jobSummary.setCluster(cluster);
		jobSummary.setMolecule(molecule);
		jobSummary.setSiteType(siteType);
		
		//from the last optimization step
		jobSummary.setEnergy(BigDecimal.valueOf(lastOptimizationStep.getTotalEnergy()).setScale(5, RoundingMode.HALF_EVEN));
		jobSummary.setForce(BigDecimal.valueOf(lastOptimizationStep.getTotalForce().length()).setScale(5, RoundingMode.HALF_EVEN));
		jobSummary.setAlphaHOMO(BigDecimal.valueOf(lastOptimizationStep.getAlphaHOMO()).setScale(5, RoundingMode.HALF_EVEN));
		jobSummary.setAlphaLUMO(BigDecimal.valueOf(lastOptimizationStep.getAlphaLUMO()).setScale(5, RoundingMode.HALF_EVEN));
		jobSummary.setBetaHOMO(BigDecimal.valueOf(lastOptimizationStep.getBetaHOMO()).setScale(5, RoundingMode.HALF_EVEN));
		jobSummary.setBetaLUMO(BigDecimal.valueOf(lastOptimizationStep.getBetaLUMO()).setScale(5, RoundingMode.HALF_EVEN));
		jobSummary.setAlphaOrbital(StringUtils.collectionToCommaDelimitedString(lastOptimizationStep.getAlphaOrbital()));
		jobSummary.setBetaOrbital(StringUtils.collectionToCommaDelimitedString(lastOptimizationStep.getBetaOrbital()));
		jobSummary.setGeometry(StringUtils.collectionToCommaDelimitedString(lastOptimizationStep.getXyzs()));
		jobSummary.setDetailedForce(StringUtils.collectionToCommaDelimitedString(lastOptimizationStep.getForces()));
		jobSummary.setUnrestrictedSpinGuess(BigDecimal.valueOf(lastOptimizationStep.getUnrestrictedSpinGuess()));
		jobSummary.setUnrestrictedSpinReal(BigDecimal.valueOf(lastOptimizationStep.getUnrestrictedSpinReal()));
		jobSummary.setRelativePath(lastOptimizationStep.getRelativeFilePath());
		
		//set start geometry from the first optimization step
		jobSummary.setStartGeometry(StringUtils.collectionToCommaDelimitedString(optimizationSteps.get(0).getXyzs()));
		//from the input params
		jobSummary.setInputParams(jaguarResultBean.getJaguarInputBean().toCommaDelimitedString());
//		jobSummary.persist();
		
//		System.out.println("Saved the final optmization result");
		
		//populate the optimization steps table
		String energies = "", forces = "", alphaHOMOs = "", alphaLUMOs = "", 
				betaHOMOs = "", betaLUMOs = "", geometries = "", detailedForces = "";
		
		int optimizationStepCounter = 1;
		for (JaguarOptimizationStepBean optimizationStep : optimizationSteps){
			GSFCJobStep gsfcJobStep = new GSFCJobStep();
			gsfcJobStep.setUniqueName(jobname);
			gsfcJobStep.setStep(optimizationStepCounter);
			BigDecimal energy = BigDecimal.valueOf(optimizationStep.getTotalEnergy()).setScale(5, RoundingMode.HALF_EVEN);
			BigDecimal force = BigDecimal.valueOf(optimizationStep.getTotalForce().length()).setScale(5, RoundingMode.HALF_EVEN);
			BigDecimal alphaHOMO = BigDecimal.valueOf(optimizationStep.getAlphaHOMO()).setScale(5, RoundingMode.HALF_EVEN);
			BigDecimal alphaLUMO = BigDecimal.valueOf(optimizationStep.getAlphaLUMO()).setScale(5, RoundingMode.HALF_EVEN);
			BigDecimal betaHOMO = BigDecimal.valueOf(optimizationStep.getBetaHOMO()).setScale(5, RoundingMode.HALF_EVEN);
			BigDecimal betaLUMO = BigDecimal.valueOf(optimizationStep.getBetaLUMO()).setScale(5, RoundingMode.HALF_EVEN);
			String geometry = StringUtils.collectionToCommaDelimitedString(optimizationStep.getXyzs());
			String detailedForce = StringUtils.collectionToCommaDelimitedString(optimizationStep.getForces());
			String alphaOrbital = StringUtils.collectionToCommaDelimitedString(optimizationStep.getAlphaOrbital());
			String betaOrbital = StringUtils.collectionToCommaDelimitedString(optimizationStep.getBetaOrbital());
			
			gsfcJobStep.setEnergy(energy);
			energies += BigDecimal.valueOf(optimizationStep.getTotalEnergy()).setScale(5, RoundingMode.HALF_EVEN).toPlainString();
			energies += ",";
			gsfcJobStep.setForce(force);
			forces += BigDecimal.valueOf(optimizationStep.getTotalForce().length()).setScale(5, RoundingMode.HALF_EVEN).toPlainString();
			forces += ",";
			gsfcJobStep.setAlphaHOMO(alphaHOMO);
			alphaHOMOs += alphaHOMO.toPlainString();
			alphaHOMOs += ",";
			gsfcJobStep.setAlphaLUMO(alphaLUMO);
			alphaLUMOs += alphaHOMO.toPlainString();
			alphaLUMOs += ",";
			gsfcJobStep.setBetaHOMO(betaHOMO);
			betaHOMOs += betaHOMO.toPlainString();
			betaHOMOs += ",";
			gsfcJobStep.setBetaLUMO(betaLUMO);
			betaLUMOs += betaLUMO.toPlainString();
			betaLUMOs += ",";
			gsfcJobStep.setGeometry(geometry);
			geometries += ( geometry + "," );
			gsfcJobStep.setDetailedForce(detailedForce);
			detailedForces += (detailedForce + ",");
			gsfcJobStep.setAlphaOrbital(alphaOrbital);
			gsfcJobStep.setBetaOrbital(betaOrbital);
			gsfcJobStep.setUnrestrictedSpinGuess(BigDecimal.valueOf(optimizationStep.getUnrestrictedSpinGuess()));
			gsfcJobStep.setUnrestrictedSpinReal(BigDecimal.valueOf(optimizationStep.getUnrestrictedSpinReal()));
			gsfcJobStep.setRelativePath(optimizationStep.getRelativeFilePath());
			gsfcJobStep.setGsfcJob(jobSummary);
//			gsfcJobStep.persist();
			optimizationStepCounter++;
		}
		
		System.out.println("Saved the optimization steps");
		
		//insert the optimizaton summary table
		GSFCOptimizationProcess optimizationProcess = new GSFCOptimizationProcess();
		optimizationProcess.setUniqueName(jobname);
		optimizationProcess.setGsfcJob(gsfcJob);
		optimizationProcess.setAlphaHOMOs(alphaHOMOs.substring(0, alphaHOMOs.length()-1));
		optimizationProcess.setAlphaLUMOs(alphaLUMOs.substring(0,alphaLUMOs.length()-1));
		optimizationProcess.setBetaHOMOs(betaHOMOs.substring(0, betaHOMOs.length()-1));
		optimizationProcess.setBetaLUMOs(betaLUMOs.substring(0,betaLUMOs.length()-1));
		optimizationProcess.setEnergies(energies.substring(0, energies.length()-1));
		optimizationProcess.setForces(forces.substring(0, forces.length()-1));
		optimizationProcess.setGeometries(geometries.substring(0, geometries.length()-1).getBytes());
		optimizationProcess.setDetailedForces(detailedForces.substring(0, detailedForces.length()-1).getBytes());
		//optimizationProcess.persist();
				
		//populate the files table
		for (JaguarFileBean jaguarFile : jaguarResultBean.getJaguarFiles()){
			GSFCStoredFiles storeEntry = new GSFCStoredFiles();
			storeEntry.setCalculationType("gs");
			storeEntry.setConvergence("fc");
			storeEntry.setFileSize(jaguarFile.getSize());
			storeEntry.setRelativePath(jaguarFile.getRelativePath());
			storeEntry.setUniqueName(jobname);
			storeEntry.setFileType(jaguarFile.getType());
			storeEntry.setGsfcJob(gsfcJob);
			//storeEntry.persist();
		}
		
		System.out.println("Saved the related files");
		
		//insert the resource table
		JobResource resource = new JobResource();
		resource.setUniqueName(jobname);
		resource.setCpus(jaguarResultBean.getJobResource().getCpus());
		// memory in mb
		resource.setMemory(jaguarResultBean.getJobResource().getMemory());
		// run time in hr
		resource.setRunTime(BigDecimal.valueOf(jaguarResultBean.getJobResource().getRuntime()/3600).setScale(1, RoundingMode.HALF_EVEN));	
		resource.persist();
		
		System.out.println("Saved Job resource");
	}
	
}
