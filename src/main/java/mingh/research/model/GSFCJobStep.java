package mingh.research.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import com.rcaloras.roo.addon.timestamp.RooTimestamp;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooTimestamp
public class GSFCJobStep extends JaguarOptimizationStep{

    @ManyToOne
    private GSFCJob gsfcJob;

}
