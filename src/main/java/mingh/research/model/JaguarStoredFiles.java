package mingh.research.model;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(inheritanceType = "TABLE_PER_CLASS")
public abstract class JaguarStoredFiles {
	
    @NotNull
    @Column(name = "unique_name")
    @Size(max = 100)
    private String uniqueName;

    @NotNull
    @Column(name = "relative_path")
    @Size(max = 500)
    private String relativePath;

    @NotNull
    @Column(name = "file_type")
    @Size(max = 20)
    private String fileType;

    @NotNull
    @Column(name = "file_size")
    @Min(1L)
    private Long fileSize;

    @NotNull
    @Column(name = "calculation_type")
    @Size(max = 10)
    private String calculationType;

    @NotNull
    @Size(max = 10)
    private String convergence;
}
