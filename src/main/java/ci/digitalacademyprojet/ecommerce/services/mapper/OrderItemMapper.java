package ci.digitalacademyprojet.ecommerce.services.mapper;

import ci.digitalacademyprojet.ecommerce.models.OrderItem;
import ci.digitalacademyprojet.ecommerce.services.DTO.OrderItemDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper extends EntityMapper<OrderItemDTO, OrderItem> {
}