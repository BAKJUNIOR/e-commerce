package ci.digitalacademyprojet.ecommerce.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {
    private Long id; // Identifiant unique de l'article de commande
    private Long orderId; // Identifiant de la commande
    private Long productId; // Identifiant du produit
    private Integer quantity; // Quantité du produit
    private Double unitPrice; // Prix unitaire
}