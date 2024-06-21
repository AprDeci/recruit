package top.aprdec.recruitweb.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2024-06-16 05:33:42
 */
@Getter
@Setter
@Data
public class Application implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer employeeId;

    private Integer jobPostingId;

    private LocalDate applicationDate;

    private String status;
}
