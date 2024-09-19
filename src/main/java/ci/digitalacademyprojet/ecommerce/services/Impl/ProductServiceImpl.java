package ci.digitalacademyprojet.ecommerce.services.Impl;
import ci.digitalacademyprojet.ecommerce.models.Product;
import ci.digitalacademyprojet.ecommerce.models.Vendor;
import ci.digitalacademyprojet.ecommerce.repositories.ProductRepository;
import ci.digitalacademyprojet.ecommerce.repositories.VendorRepository;
import ci.digitalacademyprojet.ecommerce.services.DTO.ProductDTO;
import ci.digitalacademyprojet.ecommerce.services.ProductService;
import ci.digitalacademyprojet.ecommerce.services.mapper.ProductMapper;
import ci.digitalacademyprojet.ecommerce.utils.SlugifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final VendorRepository vendorRepository;

    private final ProductMapper productMapper;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        log.debug("Request to create product:{}", productDTO);
        // Récupérer le vendeur à partir de l'ID
        Vendor vendor = vendorRepository.findById(productDTO.getVendorId())
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        Product product = productMapper.toEntity(productDTO);
        product.setVendor(vendor); // Associez le vendeur au produit
        product.setSlug(SlugifyUtils.generate(productDTO.getName()));
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }

    @Override
    public ProductDTO getProductById(Long id) {
        log.debug("Request to get product by id:{}", id);
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return productMapper.toDto(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        log.debug("Request to get all products");
        return productRepository.findAll().stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProduct(Long id) {
        log.debug("Request to delete product by id:{}", id);
        productRepository.deleteById(id);
    }

    @Override
    @Transactional
    public ProductDTO updateProduct(Long productId, ProductDTO productDTO) {
        log.debug("Request to update product by id:{} with {}", productId, productDTO);
        // Vérifiez si le produit existe
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Récupérer le vendeur à partir de l'ID
        Vendor vendor = vendorRepository.findById(productDTO.getVendorId())
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        // Mettre à jour les champs du produit
        product.setName(productDTO.getName());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImageUrl(productDTO.getImageUrl());
        product.setVendor(vendor); // Associer le vendeur

        // Enregistrer le produit mis à jour
        Product updatedProduct = productRepository.save(product);
        return productMapper.toDto(updatedProduct);
    }


}