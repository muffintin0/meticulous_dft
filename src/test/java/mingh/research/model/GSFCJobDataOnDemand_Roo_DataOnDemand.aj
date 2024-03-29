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
import mingh.research.model.GSFCJob;
import mingh.research.model.GSFCJobDataOnDemand;
import mingh.research.model.ReactionSiteTypeEnum;
import org.springframework.stereotype.Component;

privileged aspect GSFCJobDataOnDemand_Roo_DataOnDemand {
    
    declare @type: GSFCJobDataOnDemand: @Component;
    
    private Random GSFCJobDataOnDemand.rnd = new SecureRandom();
    
    private List<GSFCJob> GSFCJobDataOnDemand.data;
    
    public GSFCJob GSFCJobDataOnDemand.getNewTransientGSFCJob(int index) {
        GSFCJob obj = new GSFCJob();
        setAlphaHOMO(obj, index);
        setAlphaLUMO(obj, index);
        setAlphaOrbital(obj, index);
        setBetaHOMO(obj, index);
        setBetaLUMO(obj, index);
        setBetaOrbital(obj, index);
        setCluster(obj, index);
        setDetailedForce(obj, index);
        setEnergy(obj, index);
        setForce(obj, index);
        setGeometry(obj, index);
        setInputParams(obj, index);
        setMolecule(obj, index);
        setRelativePath(obj, index);
        setSiteType(obj, index);
        setSpin(obj, index);
        setStartGeometry(obj, index);
        setUniqueName(obj, index);
        setUnrestrictedSpinGuess(obj, index);
        setUnrestrictedSpinReal(obj, index);
        return obj;
    }
    
    public void GSFCJobDataOnDemand.setAlphaHOMO(GSFCJob obj, int index) {
        BigDecimal alphaHOMO = BigDecimal.valueOf(index);
        if (alphaHOMO.compareTo(new BigDecimal("99999.99999")) == 1) {
            alphaHOMO = new BigDecimal("99999.99999");
        }
        obj.setAlphaHOMO(alphaHOMO);
    }
    
    public void GSFCJobDataOnDemand.setAlphaLUMO(GSFCJob obj, int index) {
        BigDecimal alphaLUMO = BigDecimal.valueOf(index);
        if (alphaLUMO.compareTo(new BigDecimal("99999.99999")) == 1) {
            alphaLUMO = new BigDecimal("99999.99999");
        }
        obj.setAlphaLUMO(alphaLUMO);
    }
    
    public void GSFCJobDataOnDemand.setAlphaOrbital(GSFCJob obj, int index) {
        String alphaOrbital = "alphaOrbital_" + index;
        if (alphaOrbital.length() > 20000) {
            alphaOrbital = alphaOrbital.substring(0, 20000);
        }
        obj.setAlphaOrbital(alphaOrbital);
    }
    
    public void GSFCJobDataOnDemand.setBetaHOMO(GSFCJob obj, int index) {
        BigDecimal betaHOMO = BigDecimal.valueOf(index);
        if (betaHOMO.compareTo(new BigDecimal("99999.99999")) == 1) {
            betaHOMO = new BigDecimal("99999.99999");
        }
        obj.setBetaHOMO(betaHOMO);
    }
    
    public void GSFCJobDataOnDemand.setBetaLUMO(GSFCJob obj, int index) {
        BigDecimal betaLUMO = BigDecimal.valueOf(index);
        if (betaLUMO.compareTo(new BigDecimal("99999.99999")) == 1) {
            betaLUMO = new BigDecimal("99999.99999");
        }
        obj.setBetaLUMO(betaLUMO);
    }
    
    public void GSFCJobDataOnDemand.setBetaOrbital(GSFCJob obj, int index) {
        String betaOrbital = "betaOrbital_" + index;
        if (betaOrbital.length() > 20000) {
            betaOrbital = betaOrbital.substring(0, 20000);
        }
        obj.setBetaOrbital(betaOrbital);
    }
    
    public void GSFCJobDataOnDemand.setCluster(GSFCJob obj, int index) {
        String cluster = "cluster_" + index;
        if (cluster.length() > 10) {
            cluster = cluster.substring(0, 10);
        }
        obj.setCluster(cluster);
    }
    
    public void GSFCJobDataOnDemand.setDetailedForce(GSFCJob obj, int index) {
        String detailedForce = "detailedForce_" + index;
        if (detailedForce.length() > 5000) {
            detailedForce = detailedForce.substring(0, 5000);
        }
        obj.setDetailedForce(detailedForce);
    }
    
    public void GSFCJobDataOnDemand.setEnergy(GSFCJob obj, int index) {
        BigDecimal energy = BigDecimal.valueOf(index);
        if (energy.compareTo(new BigDecimal("99999.99999")) == 1) {
            energy = new BigDecimal("99999.99999");
        }
        obj.setEnergy(energy);
    }
    
    public void GSFCJobDataOnDemand.setForce(GSFCJob obj, int index) {
        BigDecimal force = BigDecimal.valueOf(index);
        if (force.compareTo(new BigDecimal("99999.99999")) == 1) {
            force = new BigDecimal("99999.99999");
        }
        obj.setForce(force);
    }
    
    public void GSFCJobDataOnDemand.setGeometry(GSFCJob obj, int index) {
        String geometry = "geometry_" + index;
        if (geometry.length() > 5000) {
            geometry = geometry.substring(0, 5000);
        }
        obj.setGeometry(geometry);
    }
    
    public void GSFCJobDataOnDemand.setInputParams(GSFCJob obj, int index) {
        String inputParams = "inputParams_" + index;
        if (inputParams.length() > 5000) {
            inputParams = inputParams.substring(0, 5000);
        }
        obj.setInputParams(inputParams);
    }
    
    public void GSFCJobDataOnDemand.setMolecule(GSFCJob obj, int index) {
        String molecule = "molecule_" + index;
        if (molecule.length() > 50) {
            molecule = molecule.substring(0, 50);
        }
        obj.setMolecule(molecule);
    }
    
    public void GSFCJobDataOnDemand.setRelativePath(GSFCJob obj, int index) {
        String relativePath = "relativePath_" + index;
        if (relativePath.length() > 500) {
            relativePath = relativePath.substring(0, 500);
        }
        obj.setRelativePath(relativePath);
    }
    
    public void GSFCJobDataOnDemand.setSiteType(GSFCJob obj, int index) {
        ReactionSiteTypeEnum siteType = ReactionSiteTypeEnum.class.getEnumConstants()[0];
        obj.setSiteType(siteType);
    }
    
    public void GSFCJobDataOnDemand.setSpin(GSFCJob obj, int index) {
        Integer spin = new Integer(index);
        if (spin < 1) {
            spin = 1;
        }
        obj.setSpin(spin);
    }
    
    public void GSFCJobDataOnDemand.setStartGeometry(GSFCJob obj, int index) {
        String startGeometry = "startGeometry_" + index;
        if (startGeometry.length() > 5000) {
            startGeometry = startGeometry.substring(0, 5000);
        }
        obj.setStartGeometry(startGeometry);
    }
    
    public void GSFCJobDataOnDemand.setUniqueName(GSFCJob obj, int index) {
        String uniqueName = "uniqueName_" + index;
        if (uniqueName.length() > 100) {
            uniqueName = uniqueName.substring(0, 100);
        }
        obj.setUniqueName(uniqueName);
    }
    
    public void GSFCJobDataOnDemand.setUnrestrictedSpinGuess(GSFCJob obj, int index) {
        BigDecimal unrestrictedSpinGuess = BigDecimal.valueOf(index);
        if (unrestrictedSpinGuess.compareTo(new BigDecimal("999.999")) == 1) {
            unrestrictedSpinGuess = new BigDecimal("999.999");
        }
        obj.setUnrestrictedSpinGuess(unrestrictedSpinGuess);
    }
    
    public void GSFCJobDataOnDemand.setUnrestrictedSpinReal(GSFCJob obj, int index) {
        BigDecimal unrestrictedSpinReal = BigDecimal.valueOf(index);
        if (unrestrictedSpinReal.compareTo(new BigDecimal("999.999")) == 1) {
            unrestrictedSpinReal = new BigDecimal("999.999");
        }
        obj.setUnrestrictedSpinReal(unrestrictedSpinReal);
    }
    
    public GSFCJob GSFCJobDataOnDemand.getSpecificGSFCJob(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        GSFCJob obj = data.get(index);
        Long id = obj.getId();
        return GSFCJob.findGSFCJob(id);
    }
    
    public GSFCJob GSFCJobDataOnDemand.getRandomGSFCJob() {
        init();
        GSFCJob obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return GSFCJob.findGSFCJob(id);
    }
    
    public boolean GSFCJobDataOnDemand.modifyGSFCJob(GSFCJob obj) {
        return false;
    }
    
    public void GSFCJobDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = GSFCJob.findGSFCJobEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'GSFCJob' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<GSFCJob>();
        for (int i = 0; i < 10; i++) {
            GSFCJob obj = getNewTransientGSFCJob(i);
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
