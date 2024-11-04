package online.notpeppa.blog.service.impl;

import online.notpeppa.blog.entity.User;
import online.notpeppa.blog.entity.dto.UserDto;
import online.notpeppa.blog.mapper.UserMapper;
import online.notpeppa.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void register(UserDto userDto) {
        // 1. 用户名判断
        // 1.1 不合理
        if (userDto.getUsername() == null || userDto.getUsername().isEmpty()) {
            return;
        }
        // 1.2 已存在
        if (!findByUsername(userDto.getUsername()).isEmpty()) {
            return;
        }
        // 2. 密码判断

    }

    @Override
    public List<User> findByUsername(String username) {
        Map<String,Object> map = new HashMap<>();
        map.put("username",username);
        return userMapper.selectByMap(map);
    }
}
