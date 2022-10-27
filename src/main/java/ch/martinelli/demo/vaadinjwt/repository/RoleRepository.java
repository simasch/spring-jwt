package ch.martinelli.demo.vaadinjwt.repository;

import java.util.Optional;

import ch.martinelli.demo.vaadinjwt.models.ERole;
import ch.martinelli.demo.vaadinjwt.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);
}
