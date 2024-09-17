package ci.digitalacademyprojet.ecommerce.services.Impl;

import ci.digitalacademyprojet.ecommerce.models.Category;
import ci.digitalacademyprojet.ecommerce.repositories.CategoryRepository;
import ci.digitalacademyprojet.ecommerce.services.DTO.CategoryDTO;
import ci.digitalacademyprojet.ecommerce.services.CategoryService;
import ci.digitalacademyprojet.ecommerce.services.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.toEntity(categoryDTO);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toDto(savedCategory);
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        return categoryRepository.findById(id).map(existingCategory -> {
            existingCategory.setName(categoryDTO.getName());
            existingCategory.setDescription(categoryDTO.getDescription());
            return categoryMapper.toDto(categoryRepository.save(existingCategory));
        }).orElse(null);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}