package top.aprdec.recruitweb.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
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
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    @NotNull
    private Integer id;

    private Integer userId;
    @NotNull
    private String fullname;

    private String email;

    private String phone;

    private String resumeUrl;

    private String skills;

    private String gender;
}
