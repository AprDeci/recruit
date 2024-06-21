package top.aprdec.recruitweb.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author aprdec
 * @since 2024-06-16 05:33:43
 */
@Getter
@Setter
@TableName("job_posting")
@Data
public class JobPosting implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer companyId;

//    指定该属性为employer_id列

    private Integer employerId;

    private String title;

    private String description;

    private String requirements;

    private String location;

    private LocalDate postingDate;

    private Integer maxSalary;

    private String type;

    private Integer minSalary;

}
