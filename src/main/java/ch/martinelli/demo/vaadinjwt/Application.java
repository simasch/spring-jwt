package ch.martinelli.demo.vaadinjwt;

import ch.martinelli.demo.vaadinjwt.models.Role;
import ch.martinelli.demo.vaadinjwt.models.User;
import ch.martinelli.demo.vaadinjwt.repository.RoleRepository;
import ch.martinelli.demo.vaadinjwt.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static ch.martinelli.demo.vaadinjwt.models.ERole.ROLE_USER;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Component
    class DataInitializier implements ApplicationRunner {

        private final UserRepository userRepository;
        private final RoleRepository roleRepository;
        private final PasswordEncoder passwordEncoder;

        DataInitializier(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
            this.userRepository = userRepository;
            this.roleRepository = roleRepository;
            this.passwordEncoder = passwordEncoder;
        }

        @Override
        @Transactional
        public void run(ApplicationArguments args) {
            if (!userRepository.existsByEmail("john.doe@mail.com")) {
                Role role = new Role(ROLE_USER);
                role = roleRepository.save(role);

                User user = new User("john", "john.doe@mail.com", passwordEncoder.encode("password"));
                user.getRoles().add(role);
                userRepository.save(user);
            }
        }
    }

}
