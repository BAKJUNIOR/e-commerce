package ci.digitalacademyprojet.ecommerce.services.mapper;

import ci.digitalacademyprojet.ecommerce.models.Payment;
import ci.digitalacademyprojet.ecommerce.services.DTO.PaymentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper extends EntityMapper<PaymentDTO, Payment> {
}