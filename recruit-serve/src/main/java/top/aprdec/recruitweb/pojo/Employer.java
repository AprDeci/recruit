package top.aprdec.recruitweb.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import jakarta.validation.constraints.Email;
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
@Data
public class Employer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private Integer companyId;

    private String position;

    private String name;

    private String gender;

    private String telephone;


    private String email;
}
