package online.notpeppa.blog.entity.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import online.notpeppa.blog.entity.User;

@Getter
@Setter
@Generated
@ToString
public class UserDto extends User {
    @NotBlank
    private String RePassword;
}
