package service_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;
import service_project.config.SecurityConfig;
import service_project.model.RoleType;
import service_project.model.User;
import service_project.model.UserRole;
import service_project.repository.RoleRepository;
import service_project.repository.UserRepository;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
@ComponentScan("service_project")
@EntityScan("service_project.model")
@EnableJpaRepositories("service_project.repository")
@Import(SecurityConfig.class)
public class ServiceProjectApplication implements CommandLineRunner {

@Autowired
private RoleRepository roleRepository;

@Autowired
private UserRepository userRepository;

@Autowired
private PasswordEncoder encoder;

public static void main(String[] args) {
        SpringApplication.run(ServiceProjectApplication.class, args);
        }

@Override
public void run(String... args) throws Exception {

        if (userRepository.findAll().size() == 0) {
        UserRole userRole1 = new UserRole();
        userRole1.setType(RoleType.USER);
        userRole1 = roleRepository.save(userRole1);

        UserRole userRole2 = new UserRole();
        userRole2.setType(RoleType.ADMIN);
        userRole2 = roleRepository.save(userRole2);

        User user = new User();
        user.setUsername("user@wp.pl");
        user.setPassword(encoder.encode("haslo123"));
        user.setCreateDate(new Date());
        user.setCity("Poznań");
        user.setAddress("Nowa 20s");
        user.setRoles(Arrays.asList(userRole1));
        userRepository.save(user);

        User admin = new User();
        admin.setUsername("admin@wp.pl");
        admin.setPassword(encoder.encode("haslo123"));
        admin.setCreateDate(new Date());
        admin.setCity("Wawa");
        admin.setAddress("Wesoła 11");
        admin.setRoles(Arrays.asList(userRole2));
        userRepository.save(admin);
        }
        }
        }
