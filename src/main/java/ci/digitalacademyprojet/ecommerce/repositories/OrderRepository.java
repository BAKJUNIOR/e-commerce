package ci.digitalacademyprojet.ecommerce.repositories;


import ci.digitalacademyprojet.ecommerce.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // Méthodes personnalisées peuvent être ajoutées ici plus tard
}