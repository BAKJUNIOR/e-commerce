package ci.digitalacademyprojet.ecommerce.repositories;


import ci.digitalacademyprojet.ecommerce.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}