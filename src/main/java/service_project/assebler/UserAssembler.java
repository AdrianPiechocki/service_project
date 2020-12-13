package service_project.assebler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import service_project.dto.UserDto;
import service_project.model.User;

import java.util.Date;

@Component
public class UserAssembler {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User toEntity(UserDto userDto) {
        User entity = new User();
        entity.setAddress(userDto.getAddress());
        entity.setAvatar(userDto.getAvatar());
        entity.setCity(userDto.getCity());
        entity.setCreateDate(new Date());
        entity.setUsername(userDto.getUsername());
        entity.setPassword(passwordEncoder.encode(userDto.getPassword()));

        return entity;
    }
}
