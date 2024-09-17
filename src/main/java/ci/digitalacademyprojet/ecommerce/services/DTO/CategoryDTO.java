package ci.digitalacademyprojet.ecommerce.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private Long id; // Identifiant unique de la catégorie
    private String name; // Nom de la catégorie
    private String description; // Description de la catégorie (optionnel)
}