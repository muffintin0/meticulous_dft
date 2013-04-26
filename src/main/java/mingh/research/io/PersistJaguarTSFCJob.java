package mingh.research.io;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.util.StringUtils;

import mingh.research.io.util.IRPropertyBean;
import mingh.research.io.util.JaguarFileBean;
import mingh.research.io.util.JaguarOptimizationStepBean;
import mingh.research.io.util.JaguarResultBean;
import mingh.research.io.util.Vector3d;
import mingh.research.model.JobResource;
import mingh.research.model.ReactionSiteTypeEnum;
import mingh.research.model.TSFCJob;
import mingh.research.model.TSFCJobIRProperty;
import mingh.research.model.TSFCJobStep;
import mingh.research.model.TSFCOptimizationProcess;
import mingh.research.model.TSFCStoredFiles;

public class PersistJaguarTSFCJob implements PersistJaguarJob {

	@Override
	public void persist(String jobname, JaguarResultBean jaguarResultBean) {
		if ( TSFCJob.findTSFCJobsByUniqueNameEquals(jobname).getResultList().size() == 1 ){
		System.out.println("Record exists. Skip it.");
		return;
		}
		
		List<JaguarOptimizationStepBean> optimizationSteps = jaguarResultBean.getOptimizationSteps();
		if ( optimizationSteps.size() == 0 ){
			return; //the out file does not even start run. do not persist the job
		}
		JaguarOptimizationStepBean lastOptimizationStep = optimizationSteps.get(optimizationSteps.size()-1);
		
		String[] fragments = jobname.split("-");
		int spin = Integer.parseInt(fragments[0]);
		String cluster = fragments[1];
		String molecule = fragments[2];
		String site = fragments[3];
		ReactionSiteTypeEnum siteType =ReactionSiteTypeEnum.valueOf(site);
		
		//create job entry
		TSFCJob jobSummary = new TSFCJob();
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
		
		jobSummary.persist();
		System.out.println("Saved the final optimization result");
		
		//populate the optimization steps table
		String energies = "", forces = "", alphaHOMOs = "", alphaLUMOs = "", 
				betaHOMOs = "", betaLUMOs = "", geometries = "", detailedForces = "";
		
		int optimizationStepCounter = 1;
		for (JaguarOptimizationStepBean optimizationStep : optimizationSteps){
			TSFCJobStep tsfcJobStep = new TSFCJobStep();
			tsfcJobStep.setUniqueName(jobname);
			tsfcJobStep.setStep(optimizationStepCounter);
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
			
			tsfcJobStep.setEnergy(energy);
			energies += BigDecimal.valueOf(optimizationStep.getTotalEnergy()).setScale(5, RoundingMode.HALF_EVEN).toPlainString();
			energies += ",";
			tsfcJobStep.setForce(force);
			forces += BigDecimal.valueOf(optimizationStep.getTotalForce().length()).setScale(5, RoundingMode.HALF_EVEN).toPlainString();
			forces += ",";
			tsfcJobStep.setAlphaHOMO(alphaHOMO);
			alphaHOMOs += alphaHOMO.toPlainString();
			alphaHOMOs += ",";
			tsfcJobStep.setAlphaLUMO(alphaLUMO);
			alphaLUMOs += alphaHOMO.toPlainString();
			alphaLUMOs += ",";
			tsfcJobStep.setBetaHOMO(betaHOMO);
			betaHOMOs += betaHOMO.toPlainString();
			betaHOMOs += ",";
			tsfcJobStep.setBetaLUMO(betaLUMO);
			betaLUMOs += betaLUMO.toPlainString();
			betaLUMOs += ",";
			tsfcJobStep.setGeometry(geometry);
			geometries += ( geometry + "," );
			tsfcJobStep.setDetailedForce(detailedForce);
			detailedForces += (detailedForce + ",");
			tsfcJobStep.setAlphaOrbital(alphaOrbital);
			tsfcJobStep.setBetaOrbital(betaOrbital);
			tsfcJobStep.setUnrestrictedSpinGuess(BigDecimal.valueOf(optimizationStep.getUnrestrictedSpinGuess()));
			tsfcJobStep.setUnrestrictedSpinReal(BigDecimal.valueOf(optimizationStep.getUnrestrictedSpinReal()));
			tsfcJobStep.setRelativePath(optimizationStep.getRelativeFilePath());
			tsfcJobStep.setTsfcJob(jobSummary);
			tsfcJobStep.persist();
			optimizationStepCounter++;
		}
		
		System.out.println("Saved the optimization steps");
		
		//insert the optimizaton summary table
		TSFCOptimizationProcess optimizationProcess = new TSFCOptimizationProcess();
		optimizationProcess.setUniqueName(jobname);
		optimizationProcess.setTsfcJob(jobSummary);
		optimizationProcess.setAlphaHOMOs(alphaHOMOs.substring(0, alphaHOMOs.length()-1));
		optimizationProcess.setAlphaLUMOs(alphaLUMOs.substring(0,alphaLUMOs.length()-1));
		optimizationProcess.setBetaHOMOs(betaHOMOs.substring(0, betaHOMOs.length()-1));
		optimizationProcess.setBetaLUMOs(betaLUMOs.substring(0,betaLUMOs.length()-1));
		optimizationProcess.setEnergies(energies.substring(0, energies.length()-1));
		optimizationProcess.setForces(forces.substring(0, forces.length()-1));
		optimizationProcess.setGeometries(geometries.substring(0, geometries.length()-1).getBytes());
		optimizationProcess.setDetailedForces(detailedForces.substring(0, detailedForces.length()-1).getBytes());
		optimizationProcess.persist();
	
		// if the ir property exists
		if ( jaguarResultBean.getJaguarPropertyBean().getPropertyName() == "IR" ){
			IRPropertyBean irPropertyBean = (IRPropertyBean) jaguarResultBean.getJaguarPropertyBean();
			
			//insert the IRProperty table
			TSFCJobIRProperty tsfcJobIRProperty = new TSFCJobIRProperty();
			tsfcJobIRProperty.setUniqueName(jobname);
			tsfcJobIRProperty.setFreqNumbers(StringUtils.collectionToCommaDelimitedString(irPropertyBean.getFrequencyNumbers()));
			tsfcJobIRProperty.setIntensities(StringUtils.collectionToCommaDelimitedString(irPropertyBean.getIntensities()));
			
			String normModes = "";
			for(List<Vector3d> normMode : irPropertyBean.getNormalModes()){
				normModes += StringUtils.collectionToCommaDelimitedString(normMode);
			}
			tsfcJobIRProperty.setNormModes(normModes.substring(0, normModes.length()-1).getBytes());
			tsfcJobIRProperty.setCv( BigDecimal.valueOf(irPropertyBean.getCv()) );
			tsfcJobIRProperty.setG( BigDecimal.valueOf(irPropertyBean.getG()) );
			tsfcJobIRProperty.setH( BigDecimal.valueOf(irPropertyBean.getH()) );
			tsfcJobIRProperty.setS( BigDecimal.valueOf(irPropertyBean.getS()) );
			tsfcJobIRProperty.setT( BigDecimal.valueOf(irPropertyBean.getTemperature()) );
			tsfcJobIRProperty.setU( BigDecimal.valueOf(irPropertyBean.getU()) );
			tsfcJobIRProperty.setTsfcJob(jobSummary);
			tsfcJobIRProperty.persist();
			
			//set IR property for job entry
			jobSummary.setEnthalpy(BigDecimal.valueOf(irPropertyBean.getEnthalpy()).setScale(5, RoundingMode.HALF_EVEN));
			jobSummary.setInternalEnergy(BigDecimal.valueOf(irPropertyBean.getInternalEnergy()).setScale(5, RoundingMode.HALF_EVEN));
			jobSummary.setGibbsEnergy(BigDecimal.valueOf(irPropertyBean.getGibbsEnergy()).setScale(5, RoundingMode.HALF_EVEN));
			jobSummary.setZpe(BigDecimal.valueOf(irPropertyBean.getZPE()).setScale(3, RoundingMode.HALF_EVEN));
			jobSummary.merge();
		}
		
		
		//populate the files table
		for (JaguarFileBean jaguarFile : jaguarResultBean.getJaguarFiles()){
			TSFCStoredFiles storeEntry = new TSFCStoredFiles();
			storeEntry.setCalculationType("gs");
			storeEntry.setConvergence("nc");
			storeEntry.setFileSize(jaguarFile.getSize());
			storeEntry.setRelativePath(jaguarFile.getRelativePath());
			storeEntry.setUniqueName(jobname);
			storeEntry.setFileType(jaguarFile.getType());
			storeEntry.setTsfcJob(jobSummary);
			storeEntry.persist();
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
