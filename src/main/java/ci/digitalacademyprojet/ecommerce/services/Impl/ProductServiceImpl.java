package ci.digitalacademyprojet.ecommerce.services.Impl;

import ci.digitalacademyprojet.ecommerce.models.Category;
import ci.digitalacademyprojet.ecommerce.models.Product;
import ci.digitalacademyprojet.ecommerce.models.User;
import ci.digitalacademyprojet.ecommerce.models.enums.Role;
import ci.digitalacademyprojet.ecommerce.repositories.CategoryRepository;
import ci.digitalacademyprojet.ecommerce.repositories.ProductRepository;
import ci.digitalacademyprojet.ecommerce.repositories.UserRepository;
import ci.digitalacademyprojet.ecommerce.services.CategoryService;
import ci.digitalacademyprojet.ecommerce.services.DTO.ProdFileDTO;
import ci.digitalacademyprojet.ecommerce.services.DTO.ProductDTO;
import ci.digitalacademyprojet.ecommerce.services.FileStorageService;
import ci.digitalacademyprojet.ecommerce.services.ProductService;
import ci.digitalacademyprojet.ecommerce.services.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;
    private final FileStorageService fileStorageService ;

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        // Recherche d'un utilisateur avec le rôle "VENDOR"
        User vendor = userRepository.findByRole(Role.VENDOR)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        // Recherche de la catégorie par son ID
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Product product = productMapper.toEntity(productDTO);
        product.setVendor(vendor); // Associer le vendeur
        product.setCategory(category); // Associer la catégorie
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        return productRepository.findById(id).map(existingProduct -> {
            existingProduct.setName(productDTO.getName());
            existingProduct.setDescription(productDTO.getDescription());
            existingProduct.setPrice(productDTO.getPrice());
            existingProduct.setStock(productDTO.getStock());
            // Mettre à jour la catégorie et le vendeur si nécessaire
            return productMapper.toDto(productRepository.save(existingProduct));
        }).orElse(null); // Ou gérer avec une exception
    }

    @Override
    public ProductDTO uploadProductPicture(ProdFileDTO fileDTO) throws IOException {
        if (fileDTO == null || fileDTO.getImage() == null || fileDTO.getImage().isEmpty()) {
            throw new IllegalArgumentException("FileDTO or image file must not be null or empty.");
        }


        String uploadUrl = fileStorageService.upload(fileDTO.getImage());


        ProductDTO product = new ProductDTO();
        product.setId(fileDTO.getId());
        product.setName(fileDTO.getName());
        product.setDescription(fileDTO.getDescription());
        product.setPrice(fileDTO.getPrice());
        product.setStock(fileDTO.getStock());
        product.setCategoryId(fileDTO.getCategoryId());
        product.setVendorId(fileDTO.getVendorId());
        product.setUrlPicture(uploadUrl);

        ProductDTO savedProduct = addProduct(product);

        return productMapper.toDto(productMapper.toEntity(savedProduct));
    }


    @Override
    public Optional<ProductDTO> findOne(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toDto);
    }


    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}