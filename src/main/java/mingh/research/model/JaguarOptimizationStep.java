package mingh.research.model;

import java.math.BigDecimal;

import javax.persistence.Column;
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
public abstract class JaguarOptimizationStep {
	
    @NotNull
    @Column(name = "unique_name")
    @Size(max = 100)
    private String uniqueName;

    @NotNull
    @Min(1L)
    private Integer step;

    @NotNull
    @Column(name = "scfe_energy")
    @Digits(integer = 5, fraction = 5)
    private BigDecimal energy;

    @NotNull
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
    @Size(max = 5000)
    private String geometry;

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
