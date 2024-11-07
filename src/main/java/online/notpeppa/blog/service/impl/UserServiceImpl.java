package online.notpeppa.blog.service.impl;

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
            return new ApiResponse<>(500, null, "用户名不能为空");
        }
        // 1.2 已存在
        if (!findByUsername(userDto.getUsername()).isEmpty()) {
            return new ApiResponse<>(500, null, "用户名已存在");
        }
        // 2. 密码判断
        // 2.1 两次密码不一致
        if(!Objects.equals(userDto.getPassword(), userDto.getRePassword())) {
            return new ApiResponse<>(500, null, "两次密码不一致");
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
            return new ApiResponse<>(200, null, "注册成功");
        } else {
            return new ApiResponse<>(500, null, "注册失败");
        }
    }

    @Override
    public List<User> findByUsername(String username) {
        Map<String,Object> map = new HashMap<>();
        map.put("username",username);
        return userMapper.selectByMap(map);
    }
}
