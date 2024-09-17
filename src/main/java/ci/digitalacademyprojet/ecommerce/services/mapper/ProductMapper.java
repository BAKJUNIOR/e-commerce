package ci.digitalacademyprojet.ecommerce.services.mapper;


import ci.digitalacademyprojet.ecommerce.models.Product;
import ci.digitalacademyprojet.ecommerce.models.User;
import ci.digitalacademyprojet.ecommerce.services.DTO.ProductDTO;
import ci.digitalacademyprojet.ecommerce.services.DTO.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDTO, Product>  {
}
