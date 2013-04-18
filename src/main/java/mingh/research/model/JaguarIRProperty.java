package mingh.research.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(inheritanceType = "TABLE_PER_CLASS")
public abstract class JaguarIRProperty {
	
    @NotNull
    @Size(max = 100)
    @Column(name = "unique_name")
    private String uniqueName;
    
    @NotNull
    @Column(name = "freq_numbers")
    @Size(max = 20000)
    private String freqNumbers;
    
    @NotNull
    @Size(max = 20000)
    private String intensities;
    
    @NotNull
    @Column(name = "temperature")
    @Digits(integer = 5, fraction = 3)
    private BigDecimal T;
    
    @NotNull
    @Column( name = "internal_energy")
    @Digits(integer = 5, fraction = 3)
    private BigDecimal U;
    
    @NotNull
    @Column( name = "heat_capacity" )
    @Digits(integer = 5, fraction = 3)
    private BigDecimal Cv;
    
    @NotNull
    @Column( name = "entrophy" )
    @Digits(integer = 5, fraction = 3)
    private BigDecimal S;
    
    @NotNull
    @Column( name = "enthalpy" )
    @Digits(integer = 5, fraction = 3)
    private BigDecimal H;
    
    @NotNull
    @Column( name = "gibbs_energy" )
    @Digits(integer = 5, fraction = 3)
    private BigDecimal G;
    
    @NotNull
    @Column(name = "normal_modes")
    @Lob
    private byte[] normModes;
    
}
