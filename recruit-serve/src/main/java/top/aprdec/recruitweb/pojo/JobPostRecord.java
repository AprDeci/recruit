package top.aprdec.recruitweb.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
@TableName(value = "jobpostrecords")
@Data
public class JobPostRecord implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "recordid", type = IdType.AUTO)
    private Integer recordId;

    private Integer userid;

    private Integer employeeid;

    private Integer employeruid;

    private Integer employerid;

    private Integer companyid;

    private Integer jobid;

    private String status;

}
