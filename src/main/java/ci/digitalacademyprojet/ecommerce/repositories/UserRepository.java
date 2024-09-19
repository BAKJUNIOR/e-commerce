package ci.digitalacademyprojet.ecommerce.repositories;

import ci.digitalacademyprojet.ecommerce.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}