package ch.martinelli.demo.jwt;

import ch.martinelli.demo.jwt.models.Role;
import ch.martinelli.demo.jwt.models.User;
import ch.martinelli.demo.jwt.repository.RoleRepository;
import ch.martinelli.demo.jwt.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static ch.martinelli.demo.jwt.models.ERole.ROLE_USER;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
