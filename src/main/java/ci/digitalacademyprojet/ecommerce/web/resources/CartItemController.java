package ci.digitalacademyprojet.ecommerce.web.resources;

import ci.digitalacademyprojet.ecommerce.services.CartItemService;
import ci.digitalacademyprojet.ecommerce.services.DTO.CartItemDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/cart-items")
public class CartItemController {

    private final CartItemService cartItemService;

    @PostMapping
    public ResponseEntity<CartItemDTO> createCartItem(@RequestBody CartItemDTO cartItemDTO) {
        log.debug("REST request to save CartItem {}", cartItemDTO);
        CartItemDTO createdCartItem = cartItemService.createCartItem(cartItemDTO);
        log.debug("CartItem created successfully {}", createdCartItem);
        return new ResponseEntity<>(createdCartItem, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItemDTO> getCartItemById(@PathVariable Long id) {
        log.debug("REST request to get CartItem with id: {}", id);
        CartItemDTO cartItemDTO = cartItemService.getCartItemById(id);
        log.debug("CartItem fetched successfully {}", cartItemDTO);
        return ResponseEntity.ok(cartItemDTO);
    }

    @GetMapping
    public ResponseEntity<List<CartItemDTO>> getAllCartItems() {
        log.debug("REST request to get all CartItems");
        List<CartItemDTO> cartItems = cartItemService.getAllCartItems();
        log.debug("Total CartItems fetched: {}", cartItems.size());
        return ResponseEntity.ok(cartItems);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
        log.debug("REST request to delete CartItem with id: {}", id);
        cartItemService.deleteCartItem(id);
        log.debug("CartItem with id {} deleted successfully", id);
        return ResponseEntity.noContent().build();
    }
}