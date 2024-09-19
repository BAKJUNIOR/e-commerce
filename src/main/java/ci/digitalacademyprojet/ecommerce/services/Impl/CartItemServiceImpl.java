package ci.digitalacademyprojet.ecommerce.services.Impl;
import ci.digitalacademyprojet.ecommerce.models.Cart;
import ci.digitalacademyprojet.ecommerce.models.CartItem;
import ci.digitalacademyprojet.ecommerce.models.Product;
import ci.digitalacademyprojet.ecommerce.repositories.CartItemRepository;
import ci.digitalacademyprojet.ecommerce.repositories.CartRepository;
import ci.digitalacademyprojet.ecommerce.repositories.ProductRepository;
import ci.digitalacademyprojet.ecommerce.services.CartItemService;
import ci.digitalacademyprojet.ecommerce.services.DTO.CartItemDTO;
import ci.digitalacademyprojet.ecommerce.services.mapper.CartItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Service
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    private final CartItemMapper cartItemMapper;

    @Override
    public CartItemDTO createCartItem(CartItemDTO cartItemDTO) {
        Cart cart = cartRepository.findById(cartItemDTO.getCartId())
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        Product product = productRepository.findById(cartItemDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(cartItemDTO.getQuantity());

        CartItem savedCartItem = cartItemRepository.save(cartItem);
        return new CartItemDTO(savedCartItem.getId(), cart.getId(), product.getId(), savedCartItem.getQuantity());
    }

    @Override
    public CartItemDTO getCartItemById(Long id) {
        CartItem cartItem = cartItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Cart Item not found"));
        return cartItemMapper.toDto(cartItem);
    }

    @Override
    public List<CartItemDTO> getAllCartItems() {
        return cartItemRepository.findAll().stream()
                .map(cartItemMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }
}