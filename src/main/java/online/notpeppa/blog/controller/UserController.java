package online.notpeppa.blog.controller;

import online.notpeppa.blog.entity.ApiResponse;
import online.notpeppa.blog.entity.dto.UserDto;
import online.notpeppa.blog.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 新增
     */
    @PostMapping("/register")
    public ApiResponse<Object> register(@RequestBody UserDto userDto) {
        return userService.register(userDto);
    }
}
