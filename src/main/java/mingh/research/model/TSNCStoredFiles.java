package mingh.research.model;

import javax.persistence.OneToOne;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class TSNCStoredFiles extends JaguarStoredFiles {
	
    @OneToOne
    private TSNCJob tsncJob;
}