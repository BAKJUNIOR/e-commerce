package ci.digitalacademyprojet.ecommerce.services.mapper;
import ci.digitalacademyprojet.ecommerce.models.Cart;
import ci.digitalacademyprojet.ecommerce.services.DTO.CartDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper extends EntityMapper<CartDTO, Cart> {
}