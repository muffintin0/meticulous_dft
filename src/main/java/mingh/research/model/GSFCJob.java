package mingh.research.model;

import com.rcaloras.roo.addon.timestamp.RooTimestamp;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooTimestamp
@RooJpaActiveRecord(finders = { "findGSFCJobsByUniqueNameEquals", "findGSFCJobsByUniqueNameLike" })
public class GSFCJob extends JaguarJob {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gsfcJob")
    private Set<GSFCJobStep> optimizationSteps = new HashSet<GSFCJobStep>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gsfcJob")
    private Set<GSFCStoredFiles> relatedFiles = new HashSet<GSFCStoredFiles>();
}
