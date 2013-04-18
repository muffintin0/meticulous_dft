// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package mingh.research.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mingh.research.model.JaguarIRProperty;
import org.springframework.transaction.annotation.Transactional;

privileged aspect JaguarIRProperty_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager JaguarIRProperty.entityManager;
    
    public static final EntityManager JaguarIRProperty.entityManager() {
        EntityManager em = new JaguarIRProperty() {
        }.entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long JaguarIRProperty.countJaguarIRPropertys() {
        return entityManager().createQuery("SELECT COUNT(o) FROM JaguarIRProperty o", Long.class).getSingleResult();
    }
    
    public static List<JaguarIRProperty> JaguarIRProperty.findAllJaguarIRPropertys() {
        return entityManager().createQuery("SELECT o FROM JaguarIRProperty o", JaguarIRProperty.class).getResultList();
    }
    
    public static JaguarIRProperty JaguarIRProperty.findJaguarIRProperty(Long id) {
        if (id == null) return null;
        return entityManager().find(JaguarIRProperty.class, id);
    }
    
    public static List<JaguarIRProperty> JaguarIRProperty.findJaguarIRPropertyEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM JaguarIRProperty o", JaguarIRProperty.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void JaguarIRProperty.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void JaguarIRProperty.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            JaguarIRProperty attached = JaguarIRProperty.findJaguarIRProperty(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void JaguarIRProperty.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void JaguarIRProperty.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public JaguarIRProperty JaguarIRProperty.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        JaguarIRProperty merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}