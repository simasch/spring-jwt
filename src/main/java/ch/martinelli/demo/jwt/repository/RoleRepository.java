package ch.martinelli.demo.jwt.repository;

import java.util.Optional;

import ch.martinelli.demo.jwt.models.ERole;
import ch.martinelli.demo.jwt.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);
}
