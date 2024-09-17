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
public class OrderDTO {
    private Long id; // Identifiant unique de la commande
    private Long userId; // Identifiant de l'utilisateur (client)
    private LocalDateTime orderDate; // Date et heure de la commande
    private String status; // Statut de la commande (PANIER, TERMINÉ, etc.)
}