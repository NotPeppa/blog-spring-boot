package online.notpeppa.blog.entity.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import online.notpeppa.blog.entity.User;

@Data
public class UserDto extends User {
    @NotBlank
    private String rePassword;
}
