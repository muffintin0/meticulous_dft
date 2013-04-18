package mingh.research.model;

import com.rcaloras.roo.addon.timestamp.RooTimestamp;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooTimestamp
public class GSFCStoredFiles extends JaguarStoredFiles {

    @ManyToOne
    private GSFCJob gsfcJob;
}
