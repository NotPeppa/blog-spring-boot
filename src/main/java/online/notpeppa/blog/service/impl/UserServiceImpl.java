package online.notpeppa.blog.service.impl;

import online.notpeppa.blog.constant.ApiResponseCode;
import online.notpeppa.blog.entity.ApiResponse;
import online.notpeppa.blog.entity.User;
import online.notpeppa.blog.entity.dto.UserDto;
import online.notpeppa.blog.mapper.UserMapper;
import online.notpeppa.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public ApiResponse<Object> register(UserDto userDto) {
        // 1. 用户名判断
        // 1.1 不合理
        if (userDto.getUsername() == null || userDto.getUsername().isEmpty()) {
            return ApiResponse.fail(ApiResponseCode.FAIL, null, "用户名不能为空");
        }
        // 1.2 已存在
        if (!findByUsername(userDto.getUsername()).isEmpty()) {
            return ApiResponse.fail(ApiResponseCode.FAIL, null, "用户名已存在");
        }
        // 2. 密码判断
        // 2.1 两次密码不一致
        if(!Objects.equals(userDto.getPassword(), userDto.getRePassword())) {
            return ApiResponse.fail(ApiResponseCode.FAIL, null, "两次密码不一致");
        }
        // 3. 插入数据库
        User user = new User(
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getName(),
                userDto.getAvatar(),
                userDto.getInfo(),
                userDto.getEmail(),
                userDto.getPhone(),
                userDto.getRole(),
                userDto.getSex()
        );
        // 4. 返回结果
        if (userMapper.insert(user) == 1) {
            return ApiResponse.success(null, "注册成功");
        } else {
            return ApiResponse.fail(ApiResponseCode.FAIL, null, "注册失败");
        }
    }

    @Override
    public List<User> findByUsername(String username) {
        Map<String,Object> map = new HashMap<>(1);
        map.put("username",username);
        return userMapper.selectByMap(map);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        Map<String,Object> map = new HashMap<>(2);
        map.put("username",username);
        map.put("password",password);
        if (!userMapper.selectByMap(map).isEmpty()) {
            return userMapper.selectByMap(map).get(0);
        }
        return null;
    }


}
