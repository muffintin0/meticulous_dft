// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package mingh.research.model;

import java.util.List;
import mingh.research.model.TSNCJobIRProperty;
import org.springframework.transaction.annotation.Transactional;

privileged aspect TSNCJobIRProperty_Roo_Jpa_ActiveRecord {
    
    public static long TSNCJobIRProperty.countTSNCJobIRPropertys() {
        return entityManager().createQuery("SELECT COUNT(o) FROM TSNCJobIRProperty o", Long.class).getSingleResult();
    }
    
    public static List<TSNCJobIRProperty> TSNCJobIRProperty.findAllTSNCJobIRPropertys() {
        return entityManager().createQuery("SELECT o FROM TSNCJobIRProperty o", TSNCJobIRProperty.class).getResultList();
    }
    
    public static TSNCJobIRProperty TSNCJobIRProperty.findTSNCJobIRProperty(Long id) {
        if (id == null) return null;
        return entityManager().find(TSNCJobIRProperty.class, id);
    }
    
    public static List<TSNCJobIRProperty> TSNCJobIRProperty.findTSNCJobIRPropertyEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM TSNCJobIRProperty o", TSNCJobIRProperty.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public TSNCJobIRProperty TSNCJobIRProperty.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        TSNCJobIRProperty merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
