// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package mingh.research.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;
import mingh.research.model.JaguarOptimizationStep;

privileged aspect JaguarOptimizationStep_Roo_Jpa_Entity {
    
    declare @type: JaguarOptimizationStep: @Entity;
    
    declare @type: JaguarOptimizationStep: @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS);
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private Long JaguarOptimizationStep.id;
    
    @Version
    @Column(name = "version")
    private Integer JaguarOptimizationStep.version;
    
    public Long JaguarOptimizationStep.getId() {
        return this.id;
    }
    
    public void JaguarOptimizationStep.setId(Long id) {
        this.id = id;
    }
    
    public Integer JaguarOptimizationStep.getVersion() {
        return this.version;
    }
    
    public void JaguarOptimizationStep.setVersion(Integer version) {
        this.version = version;
    }
    
}
