package ci.digitalacademyprojet.ecommerce.services.mapper;


import ci.digitalacademyprojet.ecommerce.models.Category;
import ci.digitalacademyprojet.ecommerce.models.Product;
import ci.digitalacademyprojet.ecommerce.services.DTO.CategoryDTO;
import ci.digitalacademyprojet.ecommerce.services.DTO.ProductDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryDTO, Category>  {
}
