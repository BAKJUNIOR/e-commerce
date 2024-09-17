package ci.digitalacademyprojet.ecommerce.repositories;


import ci.digitalacademyprojet.ecommerce.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Méthodes personnalisées peuvent être ajoutées ici plus tard
}