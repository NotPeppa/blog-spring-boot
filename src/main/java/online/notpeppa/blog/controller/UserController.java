package online.notpeppa.blog.controller;

import online.notpeppa.blog.entity.ApiResponse;
import online.notpeppa.blog.entity.dto.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 新增
     */
    @PostMapping("")
    public ApiResponse<Object> register(@RequestBody UserDto userDto) {

        return null;
    }
}
