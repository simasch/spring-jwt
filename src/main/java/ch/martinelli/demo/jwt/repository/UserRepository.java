package ch.martinelli.demo.jwt.repository;

import java.util.Optional;

import ch.martinelli.demo.jwt.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByUsername(String username);

  boolean existsByUsername(String username);

  boolean existsByEmail(String email);
}
