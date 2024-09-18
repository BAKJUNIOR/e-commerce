package ci.digitalacademyprojet.ecommerce.services.mapper;

import ci.digitalacademyprojet.ecommerce.models.Vendor;
import ci.digitalacademyprojet.ecommerce.services.DTO.VendorDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VendorMapper extends EntityMapper<VendorDTO, Vendor> {
}