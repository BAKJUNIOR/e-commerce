package ci.digitalacademyprojet.ecommerce.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private Set<RoleUserDTO> roleUser;
    private String slug; // Nouveau champ
    private String password; // Nouveau champ

}