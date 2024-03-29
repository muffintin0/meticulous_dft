// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package mingh.research.model;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import mingh.research.model.GSNCJob;
import mingh.research.model.GSNCJobDataOnDemand;
import mingh.research.model.ReactionSiteTypeEnum;
import org.springframework.stereotype.Component;

privileged aspect GSNCJobDataOnDemand_Roo_DataOnDemand {
    
    declare @type: GSNCJobDataOnDemand: @Component;
    
    private Random GSNCJobDataOnDemand.rnd = new SecureRandom();
    
    private List<GSNCJob> GSNCJobDataOnDemand.data;
    
    public GSNCJob GSNCJobDataOnDemand.getNewTransientGSNCJob(int index) {
        GSNCJob obj = new GSNCJob();
        setAlphaHOMO(obj, index);
        setAlphaLUMO(obj, index);
        setAlphaOrbital(obj, index);
        setBetaHOMO(obj, index);
        setBetaLUMO(obj, index);
        setBetaOrbital(obj, index);
        setCluster(obj, index);
        setDetailedForce(obj, index);
        setEnergy(obj, index);
        setEnthalpy(obj, index);
        setForce(obj, index);
        setGeometry(obj, index);
        setGibbsEnergy(obj, index);
        setInputParams(obj, index);
        setInternalEnergy(obj, index);
        setMolecule(obj, index);
        setRelativePath(obj, index);
        setSiteType(obj, index);
        setSpin(obj, index);
        setStartGeometry(obj, index);
        setUniqueName(obj, index);
        setUnrestrictedSpinGuess(obj, index);
        setUnrestrictedSpinReal(obj, index);
        setZpe(obj, index);
        return obj;
    }
    
    public void GSNCJobDataOnDemand.setAlphaHOMO(GSNCJob obj, int index) {
        BigDecimal alphaHOMO = BigDecimal.valueOf(index);
        if (alphaHOMO.compareTo(new BigDecimal("99999.99999")) == 1) {
            alphaHOMO = new BigDecimal("99999.99999");
        }
        obj.setAlphaHOMO(alphaHOMO);
    }
    
    public void GSNCJobDataOnDemand.setAlphaLUMO(GSNCJob obj, int index) {
        BigDecimal alphaLUMO = BigDecimal.valueOf(index);
        if (alphaLUMO.compareTo(new BigDecimal("99999.99999")) == 1) {
            alphaLUMO = new BigDecimal("99999.99999");
        }
        obj.setAlphaLUMO(alphaLUMO);
    }
    
    public void GSNCJobDataOnDemand.setAlphaOrbital(GSNCJob obj, int index) {
        String alphaOrbital = "alphaOrbital_" + index;
        if (alphaOrbital.length() > 20000) {
            alphaOrbital = alphaOrbital.substring(0, 20000);
        }
        obj.setAlphaOrbital(alphaOrbital);
    }
    
    public void GSNCJobDataOnDemand.setBetaHOMO(GSNCJob obj, int index) {
        BigDecimal betaHOMO = BigDecimal.valueOf(index);
        if (betaHOMO.compareTo(new BigDecimal("99999.99999")) == 1) {
            betaHOMO = new BigDecimal("99999.99999");
        }
        obj.setBetaHOMO(betaHOMO);
    }
    
    public void GSNCJobDataOnDemand.setBetaLUMO(GSNCJob obj, int index) {
        BigDecimal betaLUMO = BigDecimal.valueOf(index);
        if (betaLUMO.compareTo(new BigDecimal("99999.99999")) == 1) {
            betaLUMO = new BigDecimal("99999.99999");
        }
        obj.setBetaLUMO(betaLUMO);
    }
    
    public void GSNCJobDataOnDemand.setBetaOrbital(GSNCJob obj, int index) {
        String betaOrbital = "betaOrbital_" + index;
        if (betaOrbital.length() > 20000) {
            betaOrbital = betaOrbital.substring(0, 20000);
        }
        obj.setBetaOrbital(betaOrbital);
    }
    
    public void GSNCJobDataOnDemand.setCluster(GSNCJob obj, int index) {
        String cluster = "cluster_" + index;
        if (cluster.length() > 10) {
            cluster = cluster.substring(0, 10);
        }
        obj.setCluster(cluster);
    }
    
    public void GSNCJobDataOnDemand.setDetailedForce(GSNCJob obj, int index) {
        String detailedForce = "detailedForce_" + index;
        if (detailedForce.length() > 5000) {
            detailedForce = detailedForce.substring(0, 5000);
        }
        obj.setDetailedForce(detailedForce);
    }
    
    public void GSNCJobDataOnDemand.setEnergy(GSNCJob obj, int index) {
        BigDecimal energy = BigDecimal.valueOf(index);
        if (energy.compareTo(new BigDecimal("99999.99999")) == 1) {
            energy = new BigDecimal("99999.99999");
        }
        obj.setEnergy(energy);
    }
    
    public void GSNCJobDataOnDemand.setEnthalpy(GSNCJob obj, int index) {
        BigDecimal enthalpy = BigDecimal.valueOf(index);
        if (enthalpy.compareTo(new BigDecimal("99999.99999")) == 1) {
            enthalpy = new BigDecimal("99999.99999");
        }
        obj.setEnthalpy(enthalpy);
    }
    
    public void GSNCJobDataOnDemand.setForce(GSNCJob obj, int index) {
        BigDecimal force = BigDecimal.valueOf(index);
        if (force.compareTo(new BigDecimal("99999.99999")) == 1) {
            force = new BigDecimal("99999.99999");
        }
        obj.setForce(force);
    }
    
    public void GSNCJobDataOnDemand.setGeometry(GSNCJob obj, int index) {
        String geometry = "geometry_" + index;
        if (geometry.length() > 5000) {
            geometry = geometry.substring(0, 5000);
        }
        obj.setGeometry(geometry);
    }
    
    public void GSNCJobDataOnDemand.setGibbsEnergy(GSNCJob obj, int index) {
        BigDecimal gibbsEnergy = BigDecimal.valueOf(index);
        if (gibbsEnergy.compareTo(new BigDecimal("99999.99999")) == 1) {
            gibbsEnergy = new BigDecimal("99999.99999");
        }
        obj.setGibbsEnergy(gibbsEnergy);
    }
    
    public void GSNCJobDataOnDemand.setInputParams(GSNCJob obj, int index) {
        String inputParams = "inputParams_" + index;
        if (inputParams.length() > 5000) {
            inputParams = inputParams.substring(0, 5000);
        }
        obj.setInputParams(inputParams);
    }
    
    public void GSNCJobDataOnDemand.setInternalEnergy(GSNCJob obj, int index) {
        BigDecimal internalEnergy = BigDecimal.valueOf(index);
        if (internalEnergy.compareTo(new BigDecimal("99999.99999")) == 1) {
            internalEnergy = new BigDecimal("99999.99999");
        }
        obj.setInternalEnergy(internalEnergy);
    }
    
    public void GSNCJobDataOnDemand.setMolecule(GSNCJob obj, int index) {
        String molecule = "molecule_" + index;
        if (molecule.length() > 50) {
            molecule = molecule.substring(0, 50);
        }
        obj.setMolecule(molecule);
    }
    
    public void GSNCJobDataOnDemand.setRelativePath(GSNCJob obj, int index) {
        String relativePath = "relativePath_" + index;
        if (relativePath.length() > 500) {
            relativePath = relativePath.substring(0, 500);
        }
        obj.setRelativePath(relativePath);
    }
    
    public void GSNCJobDataOnDemand.setSiteType(GSNCJob obj, int index) {
        ReactionSiteTypeEnum siteType = ReactionSiteTypeEnum.class.getEnumConstants()[0];
        obj.setSiteType(siteType);
    }
    
    public void GSNCJobDataOnDemand.setSpin(GSNCJob obj, int index) {
        Integer spin = new Integer(index);
        if (spin < 1) {
            spin = 1;
        }
        obj.setSpin(spin);
    }
    
    public void GSNCJobDataOnDemand.setStartGeometry(GSNCJob obj, int index) {
        String startGeometry = "startGeometry_" + index;
        if (startGeometry.length() > 5000) {
            startGeometry = startGeometry.substring(0, 5000);
        }
        obj.setStartGeometry(startGeometry);
    }
    
    public void GSNCJobDataOnDemand.setUniqueName(GSNCJob obj, int index) {
        String uniqueName = "uniqueName_" + index;
        if (uniqueName.length() > 100) {
            uniqueName = uniqueName.substring(0, 100);
        }
        obj.setUniqueName(uniqueName);
    }
    
    public void GSNCJobDataOnDemand.setUnrestrictedSpinGuess(GSNCJob obj, int index) {
        BigDecimal unrestrictedSpinGuess = BigDecimal.valueOf(index);
        if (unrestrictedSpinGuess.compareTo(new BigDecimal("999.999")) == 1) {
            unrestrictedSpinGuess = new BigDecimal("999.999");
        }
        obj.setUnrestrictedSpinGuess(unrestrictedSpinGuess);
    }
    
    public void GSNCJobDataOnDemand.setUnrestrictedSpinReal(GSNCJob obj, int index) {
        BigDecimal unrestrictedSpinReal = BigDecimal.valueOf(index);
        if (unrestrictedSpinReal.compareTo(new BigDecimal("999.999")) == 1) {
            unrestrictedSpinReal = new BigDecimal("999.999");
        }
        obj.setUnrestrictedSpinReal(unrestrictedSpinReal);
    }
    
    public void GSNCJobDataOnDemand.setZpe(GSNCJob obj, int index) {
        BigDecimal zpe = BigDecimal.valueOf(index);
        if (zpe.compareTo(new BigDecimal("99999.999")) == 1) {
            zpe = new BigDecimal("99999.999");
        }
        obj.setZpe(zpe);
    }
    
    public GSNCJob GSNCJobDataOnDemand.getSpecificGSNCJob(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        GSNCJob obj = data.get(index);
        Long id = obj.getId();
        return GSNCJob.findGSNCJob(id);
    }
    
    public GSNCJob GSNCJobDataOnDemand.getRandomGSNCJob() {
        init();
        GSNCJob obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return GSNCJob.findGSNCJob(id);
    }
    
    public boolean GSNCJobDataOnDemand.modifyGSNCJob(GSNCJob obj) {
        return false;
    }
    
    public void GSNCJobDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = GSNCJob.findGSNCJobEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'GSNCJob' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<GSNCJob>();
        for (int i = 0; i < 10; i++) {
            GSNCJob obj = getNewTransientGSNCJob(i);
            try {
                obj.persist();
            } catch (ConstraintViolationException e) {
                StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getConstraintDescriptor()).append(":").append(cv.getMessage()).append("=").append(cv.getInvalidValue()).append("]");
                }
                throw new RuntimeException(msg.toString(), e);
            }
            obj.flush();
            data.add(obj);
        }
    }
    
}
