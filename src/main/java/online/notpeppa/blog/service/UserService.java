package online.notpeppa.blog.service;

import online.notpeppa.blog.entity.User;
import online.notpeppa.blog.entity.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public void register(UserDto userDto);
    public List<User> findByUsername(String username);
}
