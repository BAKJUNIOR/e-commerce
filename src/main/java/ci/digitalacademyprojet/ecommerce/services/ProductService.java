package ci.digitalacademyprojet.ecommerce.services;

import ci.digitalacademyprojet.ecommerce.services.DTO.ProdFileDTO;
import ci.digitalacademyprojet.ecommerce.services.DTO.ProductDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO addProduct(ProductDTO productDTO);
    ProductDTO updateProduct(Long id, ProductDTO productDTO);
    Optional<ProductDTO>findOne(Long id);
    ProductDTO uploadProductPicture(ProdFileDTO fileDTO) throws IOException;
    void deleteProduct(Long id);
}