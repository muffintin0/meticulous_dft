// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package mingh.research.model;

import java.util.List;
import mingh.research.model.TSNCJobStep;
import org.springframework.transaction.annotation.Transactional;

privileged aspect TSNCJobStep_Roo_Jpa_ActiveRecord {
    
    public static long TSNCJobStep.countTSNCJobSteps() {
        return entityManager().createQuery("SELECT COUNT(o) FROM TSNCJobStep o", Long.class).getSingleResult();
    }
    
    public static List<TSNCJobStep> TSNCJobStep.findAllTSNCJobSteps() {
        return entityManager().createQuery("SELECT o FROM TSNCJobStep o", TSNCJobStep.class).getResultList();
    }
    
    public static TSNCJobStep TSNCJobStep.findTSNCJobStep(Long id) {
        if (id == null) return null;
        return entityManager().find(TSNCJobStep.class, id);
    }
    
    public static List<TSNCJobStep> TSNCJobStep.findTSNCJobStepEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM TSNCJobStep o", TSNCJobStep.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public TSNCJobStep TSNCJobStep.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        TSNCJobStep merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
