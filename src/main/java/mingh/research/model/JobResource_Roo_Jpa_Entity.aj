// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package mingh.research.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import mingh.research.model.JobResource;

privileged aspect JobResource_Roo_Jpa_Entity {
    
    declare @type: JobResource: @Entity;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long JobResource.id;
    
    @Version
    @Column(name = "version")
    private Integer JobResource.version;
    
    public Long JobResource.getId() {
        return this.id;
    }
    
    public void JobResource.setId(Long id) {
        this.id = id;
    }
    
    public Integer JobResource.getVersion() {
        return this.version;
    }
    
    public void JobResource.setVersion(Integer version) {
        this.version = version;
    }
    
}
