package ci.digitalacademyprojet.ecommerce.repositories;

import ci.digitalacademyprojet.ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}