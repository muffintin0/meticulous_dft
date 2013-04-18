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
@RooJpaActiveRecord
public class JobResource {

    @NotNull
    @Size( max = 100)
    @Column( name ="unique_name" )
    private String uniqueName;

    @NotNull
    @Min(0L)
    private Integer cpus;

    @NotNull
    @Min(0L)
    private Integer memory; // in mb

    @NotNull
    @Min(0L)
    @Column( name = "run_time" )
    @Digits(integer = 5, fraction = 1)
    private BigDecimal runTime; // in hr
}
