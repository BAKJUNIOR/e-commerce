package ci.digitalacademyprojet.ecommerce.repositories;

import ci.digitalacademyprojet.ecommerce.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // Méthodes personnalisées peuvent être ajoutées ici plus tard
}