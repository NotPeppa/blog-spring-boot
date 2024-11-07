package online.notpeppa.blog.service;

import online.notpeppa.blog.entity.ApiResponse;
import online.notpeppa.blog.entity.User;
import online.notpeppa.blog.entity.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public ApiResponse<Object> register(UserDto userDto);
    public List<User> findByUsername(String username);
    public User findByUsernameAndPassword(String username, String password);
}
