package ci.digitalacademyprojet.ecommerce.repositories;



import ci.digitalacademyprojet.ecommerce.models.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface RoleUserRepository extends JpaRepository<RoleUser, Long> {
    Collection<Object> findBynameRole(String roleUser);
}
