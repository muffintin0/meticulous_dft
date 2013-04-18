// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package mingh.research.model;

import java.util.List;
import mingh.research.model.GSFCJobStep;
import org.springframework.transaction.annotation.Transactional;

privileged aspect GSFCJobStep_Roo_Jpa_ActiveRecord {
    
    public static long GSFCJobStep.countGSFCJobSteps() {
        return entityManager().createQuery("SELECT COUNT(o) FROM GSFCJobStep o", Long.class).getSingleResult();
    }
    
    public static List<GSFCJobStep> GSFCJobStep.findAllGSFCJobSteps() {
        return entityManager().createQuery("SELECT o FROM GSFCJobStep o", GSFCJobStep.class).getResultList();
    }
    
    public static GSFCJobStep GSFCJobStep.findGSFCJobStep(Long id) {
        if (id == null) return null;
        return entityManager().find(GSFCJobStep.class, id);
    }
    
    public static List<GSFCJobStep> GSFCJobStep.findGSFCJobStepEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM GSFCJobStep o", GSFCJobStep.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public GSFCJobStep GSFCJobStep.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        GSFCJobStep merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}