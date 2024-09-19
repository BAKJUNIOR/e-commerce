package ci.digitalacademyprojet.ecommerce.services.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JWTTokenDTO {
    @JsonIgnoreProperties("id_token")
    private String idtoken;
}