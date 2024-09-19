package ci.digitalacademyprojet.ecommerce.services.mapper;
import ci.digitalacademyprojet.ecommerce.models.Cart;
import ci.digitalacademyprojet.ecommerce.models.RoleUser;
import ci.digitalacademyprojet.ecommerce.services.DTO.CartDTO;
import ci.digitalacademyprojet.ecommerce.services.DTO.RoleUserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleUserMapper extends EntityMapper<RoleUserDTO, RoleUser> {
}