package ci.digitalacademyprojet.ecommerce.services.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
    private String username;
    private String password;
    private boolean rememberMe;
}