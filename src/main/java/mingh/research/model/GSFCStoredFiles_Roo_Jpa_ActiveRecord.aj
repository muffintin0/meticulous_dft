// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package mingh.research.model;

import java.util.List;
import mingh.research.model.GSFCStoredFiles;
import org.springframework.transaction.annotation.Transactional;

privileged aspect GSFCStoredFiles_Roo_Jpa_ActiveRecord {
    
    public static long GSFCStoredFiles.countGSFCStoredFileses() {
        return entityManager().createQuery("SELECT COUNT(o) FROM GSFCStoredFiles o", Long.class).getSingleResult();
    }
    
    public static List<GSFCStoredFiles> GSFCStoredFiles.findAllGSFCStoredFileses() {
        return entityManager().createQuery("SELECT o FROM GSFCStoredFiles o", GSFCStoredFiles.class).getResultList();
    }
    
    public static GSFCStoredFiles GSFCStoredFiles.findGSFCStoredFiles(Long id) {
        if (id == null) return null;
        return entityManager().find(GSFCStoredFiles.class, id);
    }
    
    public static List<GSFCStoredFiles> GSFCStoredFiles.findGSFCStoredFilesEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM GSFCStoredFiles o", GSFCStoredFiles.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public GSFCStoredFiles GSFCStoredFiles.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        GSFCStoredFiles merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
