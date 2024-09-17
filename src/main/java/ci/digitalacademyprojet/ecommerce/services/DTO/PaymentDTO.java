package ci.digitalacademyprojet.ecommerce.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private Long id; // Identifiant unique du paiement
    private Long orderId; // Identifiant de la commande
    private Double amount; // Montant du paiement
    private LocalDateTime paymentDate; // Date et heure du paiement
    private String paymentMethod; // Méthode de paiement
    private String status; // Statut du paiement
}