package service_project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import service_project.assebler.UserAssembler;
import service_project.dto.UserDto;
import service_project.model.RoleType;
import service_project.model.User;
import service_project.model.UserRole;
import service_project.repository.RoleRepository;
import service_project.repository.UserRepository;

import java.util.Arrays;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final UserAssembler userAssembler;
    private final RoleRepository roleRepository;

    public Long save(UserDto userDto) {
        User user = userAssembler.toEntity(userDto);
        Optional<UserRole> userRole = roleRepository.findByType(RoleType.USER);
        user.setRoles(Arrays.asList(userRole.get()));
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }
}
