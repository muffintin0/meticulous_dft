// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package mingh.research.model;

import java.util.List;
import mingh.research.model.GSNCOptimizationProcess;
import org.springframework.transaction.annotation.Transactional;

privileged aspect GSNCOptimizationProcess_Roo_Jpa_ActiveRecord {
    
    public static long GSNCOptimizationProcess.countGSNCOptimizationProcesses() {
        return entityManager().createQuery("SELECT COUNT(o) FROM GSNCOptimizationProcess o", Long.class).getSingleResult();
    }
    
    public static List<GSNCOptimizationProcess> GSNCOptimizationProcess.findAllGSNCOptimizationProcesses() {
        return entityManager().createQuery("SELECT o FROM GSNCOptimizationProcess o", GSNCOptimizationProcess.class).getResultList();
    }
    
    public static GSNCOptimizationProcess GSNCOptimizationProcess.findGSNCOptimizationProcess(Long id) {
        if (id == null) return null;
        return entityManager().find(GSNCOptimizationProcess.class, id);
    }
    
    public static List<GSNCOptimizationProcess> GSNCOptimizationProcess.findGSNCOptimizationProcessEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM GSNCOptimizationProcess o", GSNCOptimizationProcess.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public GSNCOptimizationProcess GSNCOptimizationProcess.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        GSNCOptimizationProcess merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
