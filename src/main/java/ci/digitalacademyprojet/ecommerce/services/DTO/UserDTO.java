package ci.digitalacademyprojet.ecommerce.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id; // Identifiant unique de l'utilisateur
    private String username; // Nom d'utilisateur
    private String password; // Vérifie que ce champ est bien présent
    private String email; // Adresse email
    private String role; // Rôle de l'utilisateur (CLIENT, VENDOR, ADMIN)
}