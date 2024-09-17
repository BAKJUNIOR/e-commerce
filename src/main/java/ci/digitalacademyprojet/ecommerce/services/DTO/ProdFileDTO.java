package ci.digitalacademyprojet.ecommerce.services.DTO;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProdFileDTO extends ProductDTO{
    private MultipartFile image;
}
