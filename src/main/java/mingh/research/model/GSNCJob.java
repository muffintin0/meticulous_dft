package mingh.research.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class GSNCJob extends JaguarJob {
	
	//from freq 
	
	@NotNull
	@Min(0L)
	@Digits(integer = 5, fraction = 3)
	private BigDecimal zpe;
	
    @NotNull
    @Column(name = "internal_energy")
    @Digits(integer = 5, fraction = 5)
    private BigDecimal internalEnergy;
    
    @NotNull
    @Digits(integer = 5, fraction = 5)
    private BigDecimal enthalpy;
    
    @NotNull
    @Column(name = "gibbs_energy")
    @Digits(integer = 5, fraction = 5)
    private BigDecimal gibbsEnergy;
	
	
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gsncJob")
    private Set<GSNCJobStep> optimizationSteps = new HashSet<GSNCJobStep>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gsncJob")
    private Set<GSNCStoredFiles> relatedFiles = new HashSet<GSNCStoredFiles>();
}
