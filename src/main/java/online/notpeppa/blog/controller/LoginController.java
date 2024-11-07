package online.notpeppa.blog.controller;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import online.notpeppa.blog.constant.ApiResponseCode;
import online.notpeppa.blog.entity.ApiResponse;
import online.notpeppa.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import online.notpeppa.blog.entity.User;

import java.util.Map;

@RestController
@RequestMapping("/acc")
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 登陆
     */
    @PostMapping("/login")
    public ApiResponse<Object> login(@RequestBody User user) {
        User result = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (result != null) {
            StpUtil.login(result.getId());
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            // 将tokenInfo中的tokenName和tokenValue返回给前端
            Map<String, String> tokenMap = Map.of(tokenInfo.getTokenName(), tokenInfo.getTokenValue());
            return ApiResponse.success(tokenMap, "登陆成功");
        }
        return ApiResponse.fail(ApiResponseCode.FAIL,null,"请检查用户名和密码是否正确！");
    }

    /**
     * 注销
     */
    @GetMapping("/logout")
    public ApiResponse<Object> logout() throws NotLoginException {
        StpUtil.checkLogin();
        StpUtil.logout();
        return ApiResponse.success(null, "用户已退出");
    }
}
