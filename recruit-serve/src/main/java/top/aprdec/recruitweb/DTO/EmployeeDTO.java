package top.aprdec.recruitweb.DTO;


import lombok.Data;

@Data
public class EmployeeDTO {
    String username;
    private Integer id;

    private Integer userId;

    private String fullname;

    private String email;

    private String phone;

    private String resumeUrl;

    private String skills;

    private String gender;
}
