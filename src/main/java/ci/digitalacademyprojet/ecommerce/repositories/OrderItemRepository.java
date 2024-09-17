package ci.digitalacademyprojet.ecommerce.repositories;


import ci.digitalacademyprojet.ecommerce.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    // Méthodes personnalisées peuvent être ajoutées ici plus tard
}