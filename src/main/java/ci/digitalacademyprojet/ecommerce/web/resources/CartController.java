package ci.digitalacademyprojet.ecommerce.web.resources;

import ci.digitalacademyprojet.ecommerce.services.CartService;
import ci.digitalacademyprojet.ecommerce.services.DTO.CartDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;

    @PostMapping
    public ResponseEntity<CartDTO> createCart(@RequestBody CartDTO cartDTO) {
        log.debug("REST request to save Cart {}", cartDTO);
        CartDTO createdCart = cartService.createCart(cartDTO);
        log.debug("Cart created successfully {}", createdCart);
        return new ResponseEntity<>(createdCart, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDTO> getCartById(@PathVariable Long id) {
        log.debug("REST request to get Cart with id: {}", id);
        CartDTO cartDTO = cartService.getCartById(id);
        log.debug("Cart fetched successfully {}", cartDTO);
        return ResponseEntity.ok(cartDTO);
    }

    @GetMapping
    public ResponseEntity<List<CartDTO>> getAllCarts() {
        log.debug("REST request to get all Carts");
        List<CartDTO> carts = cartService.getAllCarts();
        log.debug("Total Carts fetched: {}", carts.size());
        return ResponseEntity.ok(carts);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
        log.debug("REST request to delete Cart with id: {}", id);
        cartService.deleteCart(id);
        log.debug("Cart with id {} deleted successfully", id);
        return ResponseEntity.noContent().build();
    }
}