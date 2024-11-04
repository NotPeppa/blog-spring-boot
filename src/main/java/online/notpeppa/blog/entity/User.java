package online.notpeppa.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@TableName("user")
public class User extends BaseEntity{
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String name;
    private String avatar;
    private String role;
    private String sex;
    private String phone;
    @Email
    private String email;
    private String info;

}
