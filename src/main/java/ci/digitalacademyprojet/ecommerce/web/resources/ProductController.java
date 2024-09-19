package ci.digitalacademyprojet.ecommerce.web.resources;

import ci.digitalacademyprojet.ecommerce.services.DTO.ProductDTO;
import ci.digitalacademyprojet.ecommerce.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        log.debug("REST request to create product {}", productDTO);
        ProductDTO createdProduct = productService.createProduct(productDTO);
        log.debug("Product created successfully {}", createdProduct);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        log.debug("REST request to get product by id {}", id);
        ProductDTO productDTO = productService.getProductById(id);
        log.debug("Product fetched successfully {}", productDTO);
        return ResponseEntity.ok(productDTO);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        log.debug("REST request to get all products");
        List<ProductDTO> products = productService.getAllProducts();
        log.debug("Total products fetched: {}", products.size());
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        log.debug("REST request to delete product with id {}", id);
        productService.deleteProduct(id);
        log.debug("Product with id {} deleted successfully", id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductDTO productDTO) {
        log.debug("REST request to update product with id {} {}", id, productDTO);
        ProductDTO updatedProduct = productService.updateProduct(id, productDTO);
        log.debug("Product updated successfully {}", updatedProduct);
        return ResponseEntity.ok(updatedProduct);
    }
}