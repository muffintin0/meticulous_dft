// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package mingh.research.model;

import java.util.List;
import mingh.research.model.TSNCJob;
import org.springframework.transaction.annotation.Transactional;

privileged aspect TSNCJob_Roo_Jpa_ActiveRecord {
    
    public static long TSNCJob.countTSNCJobs() {
        return entityManager().createQuery("SELECT COUNT(o) FROM TSNCJob o", Long.class).getSingleResult();
    }
    
    public static List<TSNCJob> TSNCJob.findAllTSNCJobs() {
        return entityManager().createQuery("SELECT o FROM TSNCJob o", TSNCJob.class).getResultList();
    }
    
    public static TSNCJob TSNCJob.findTSNCJob(Long id) {
        if (id == null) return null;
        return entityManager().find(TSNCJob.class, id);
    }
    
    public static List<TSNCJob> TSNCJob.findTSNCJobEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM TSNCJob o", TSNCJob.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public TSNCJob TSNCJob.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        TSNCJob merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}