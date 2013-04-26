// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package mingh.research.model;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import mingh.research.model.TSNCJob;

privileged aspect TSNCJob_Roo_Finder {
    
    public static TypedQuery<TSNCJob> TSNCJob.findTSNCJobsByUniqueNameEquals(String uniqueName) {
        if (uniqueName == null || uniqueName.length() == 0) throw new IllegalArgumentException("The uniqueName argument is required");
        EntityManager em = TSNCJob.entityManager();
        TypedQuery<TSNCJob> q = em.createQuery("SELECT o FROM TSNCJob AS o WHERE o.uniqueName = :uniqueName", TSNCJob.class);
        q.setParameter("uniqueName", uniqueName);
        return q;
    }
    
    public static TypedQuery<TSNCJob> TSNCJob.findTSNCJobsByUniqueNameLike(String uniqueName) {
        if (uniqueName == null || uniqueName.length() == 0) throw new IllegalArgumentException("The uniqueName argument is required");
        uniqueName = uniqueName.replace('*', '%');
        if (uniqueName.charAt(0) != '%') {
            uniqueName = "%" + uniqueName;
        }
        if (uniqueName.charAt(uniqueName.length() - 1) != '%') {
            uniqueName = uniqueName + "%";
        }
        EntityManager em = TSNCJob.entityManager();
        TypedQuery<TSNCJob> q = em.createQuery("SELECT o FROM TSNCJob AS o WHERE LOWER(o.uniqueName) LIKE LOWER(:uniqueName)", TSNCJob.class);
        q.setParameter("uniqueName", uniqueName);
        return q;
    }
    
}
