package mingh.research.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(inheritanceType = "TABLE_PER_CLASS")
public abstract class JaguarJob {
	
    @NotNull
    @Size(max = 100)
    @Column(name = "unique_name")
    private String uniqueName;

    @NotNull
    @Min(1L)
    private Integer spin;

    @NotNull
    @Size(max = 10)
    private String cluster;

    @NotNull
    @Size(max = 50)
    private String molecule;

    @NotNull
    @Column(name = "site_type")
    @Enumerated(EnumType.STRING)
    private ReactionSiteTypeEnum siteType;

    @NotNull
    @Column(name = "scfe_energy")
    @Digits(integer = 5, fraction = 5)
    private BigDecimal energy;

    @Column(name = "total_force")
    @Digits(integer = 5, fraction = 5)
    private BigDecimal force;

    @NotNull
    @Column(name = "alpha_homo")
    @Digits(integer = 5, fraction = 5)
    private BigDecimal alphaHOMO;

	@NotNull
    @Column(name = "alpha_lumo")
    @Digits(integer = 5, fraction = 5)
    private BigDecimal alphaLUMO;

    @NotNull
    @Column(name = "beta_homo")
    @Digits(integer = 5, fraction = 5)
    private BigDecimal betaHOMO;

    @NotNull
    @Column(name = "beta_lumo")
    @Digits(integer = 5, fraction = 5)
    private BigDecimal betaLUMO;

    @NotNull
    @Column(name = "input_params")
    @Size(max = 5000)
    private String inputParams;

    @NotNull
    @Column(name = "geometry")
    @Size(max = 5000)
    private String geometry;

    @NotNull
    @Column(name = "start_geometry")
    @Size(max = 5000)
    private String startGeometry;

    @NotNull
    @Column(name = "detailed_force")
    @Size(max = 5000)
    private String detailedForce;

    @NotNull
    @Column(name = "alpha_orbital")
    @Size(max = 20000)
    private String alphaOrbital;

    @NotNull
    @Column(name = "beta_orbital")
    @Size(max = 20000)
    private String betaOrbital;

    @NotNull
    @Column(name = "unrestricted_spin_real")
    @Digits(integer = 3, fraction = 3)
    private BigDecimal unrestrictedSpinReal;

    @NotNull
    @Column(name = "unrestricted_spin_guess")
    @Digits(integer = 3, fraction = 3)
    private BigDecimal unrestrictedSpinGuess;

    @NotNull
    @Size(max = 500)
    private String relativePath;
    
    
}
