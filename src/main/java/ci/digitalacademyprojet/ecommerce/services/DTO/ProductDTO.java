package ci.digitalacademyprojet.ecommerce.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id; // Identifiant unique du produit
    private String name; // Nom du produit
    private String description; // Description du produit
    private Double price; // Prix du produit
    private Integer stock; // Quantité disponible
    private Long categoryId; // Identifiant de la catégorie
    private Long vendorId; // Identifiant du vendeur
}