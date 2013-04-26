// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package mingh.research.model;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import mingh.research.model.TSNCJobDataOnDemand;
import mingh.research.model.TSNCStoredFiles;
import mingh.research.model.TSNCStoredFilesDataOnDemand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect TSNCStoredFilesDataOnDemand_Roo_DataOnDemand {
    
    declare @type: TSNCStoredFilesDataOnDemand: @Component;
    
    private Random TSNCStoredFilesDataOnDemand.rnd = new SecureRandom();
    
    private List<TSNCStoredFiles> TSNCStoredFilesDataOnDemand.data;
    
    @Autowired
    TSNCJobDataOnDemand TSNCStoredFilesDataOnDemand.tSNCJobDataOnDemand;
    
    public TSNCStoredFiles TSNCStoredFilesDataOnDemand.getNewTransientTSNCStoredFiles(int index) {
        TSNCStoredFiles obj = new TSNCStoredFiles();
        setCalculationType(obj, index);
        setConvergence(obj, index);
        setFileSize(obj, index);
        setFileType(obj, index);
        setRelativePath(obj, index);
        setUniqueName(obj, index);
        return obj;
    }
    
    public void TSNCStoredFilesDataOnDemand.setCalculationType(TSNCStoredFiles obj, int index) {
        String calculationType = "calculat_" + index;
        if (calculationType.length() > 10) {
            calculationType = calculationType.substring(0, 10);
        }
        obj.setCalculationType(calculationType);
    }
    
    public void TSNCStoredFilesDataOnDemand.setConvergence(TSNCStoredFiles obj, int index) {
        String convergence = "converge_" + index;
        if (convergence.length() > 10) {
            convergence = convergence.substring(0, 10);
        }
        obj.setConvergence(convergence);
    }
    
    public void TSNCStoredFilesDataOnDemand.setFileSize(TSNCStoredFiles obj, int index) {
        Long fileSize = new Integer(index).longValue();
        if (fileSize < 1L) {
            fileSize = 1L;
        }
        obj.setFileSize(fileSize);
    }
    
    public void TSNCStoredFilesDataOnDemand.setFileType(TSNCStoredFiles obj, int index) {
        String fileType = "fileType_" + index;
        if (fileType.length() > 20) {
            fileType = fileType.substring(0, 20);
        }
        obj.setFileType(fileType);
    }
    
    public void TSNCStoredFilesDataOnDemand.setRelativePath(TSNCStoredFiles obj, int index) {
        String relativePath = "relativePath_" + index;
        if (relativePath.length() > 500) {
            relativePath = relativePath.substring(0, 500);
        }
        obj.setRelativePath(relativePath);
    }
    
    public void TSNCStoredFilesDataOnDemand.setUniqueName(TSNCStoredFiles obj, int index) {
        String uniqueName = "uniqueName_" + index;
        if (uniqueName.length() > 100) {
            uniqueName = uniqueName.substring(0, 100);
        }
        obj.setUniqueName(uniqueName);
    }
    
    public TSNCStoredFiles TSNCStoredFilesDataOnDemand.getSpecificTSNCStoredFiles(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        TSNCStoredFiles obj = data.get(index);
        Long id = obj.getId();
        return TSNCStoredFiles.findTSNCStoredFiles(id);
    }
    
    public TSNCStoredFiles TSNCStoredFilesDataOnDemand.getRandomTSNCStoredFiles() {
        init();
        TSNCStoredFiles obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return TSNCStoredFiles.findTSNCStoredFiles(id);
    }
    
    public boolean TSNCStoredFilesDataOnDemand.modifyTSNCStoredFiles(TSNCStoredFiles obj) {
        return false;
    }
    
    public void TSNCStoredFilesDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = TSNCStoredFiles.findTSNCStoredFilesEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'TSNCStoredFiles' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<TSNCStoredFiles>();
        for (int i = 0; i < 10; i++) {
            TSNCStoredFiles obj = getNewTransientTSNCStoredFiles(i);
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
