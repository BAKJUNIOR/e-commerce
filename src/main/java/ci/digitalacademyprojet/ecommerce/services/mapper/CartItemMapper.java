package ci.digitalacademyprojet.ecommerce.services.mapper;


import ci.digitalacademyprojet.ecommerce.models.CartItem;
import ci.digitalacademyprojet.ecommerce.services.DTO.CartItemDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartItemMapper extends EntityMapper<CartItemDTO, CartItem> {
}