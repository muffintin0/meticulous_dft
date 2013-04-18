package mingh.research.model;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(inheritanceType = "TABLE_PER_CLASS")
public abstract class JaguarOptimizationProcess {
	
    @NotNull
    @Column(name = "unique_name")
    @Size(max = 100)
    private String uniqueName;

    @NotNull
    @Column(name = "scfe_energies")
    @Size(max = 10000)
    private String energies;

    @NotNull
    @Column(name = "total_forces")
    @Size(max = 10000)
    private String forces;

    @NotNull
    @Size(max = 10000)
    private String alphaHOMOs;

    @NotNull
    @Size(max = 10000)
    private String alphaLUMOs;

    @NotNull
    @Size(max = 10000)
    private String betaHOMOs;

    @NotNull
    @Size(max = 10000)
    private String betaLUMOs;

    @NotNull
    @Column(name = "geometries")
    @Lob
    private byte[] geometries;

    @NotNull
    @Column(name = "detailed_forces")
    @Lob
    private byte[] detailedForces;
}
