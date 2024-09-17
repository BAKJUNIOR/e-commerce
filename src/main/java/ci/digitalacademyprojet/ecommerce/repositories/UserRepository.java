package ci.digitalacademyprojet.ecommerce.repositories;

import ci.digitalacademyprojet.ecommerce.models.User;
import ci.digitalacademyprojet.ecommerce.models.enums.Role;
import ci.digitalacademyprojet.ecommerce.services.DTO.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByRole(Role role);

    Optional<Object> findByUsername(String username);
    // Méthodes personnalisées peuvent être ajoutées ici plus tard
}