package ci.digitalacademyprojet.ecommerce.services.Impl;

import ci.digitalacademyprojet.ecommerce.models.Cart;
import ci.digitalacademyprojet.ecommerce.models.User;
import ci.digitalacademyprojet.ecommerce.repositories.CartRepository;
import ci.digitalacademyprojet.ecommerce.repositories.UserRepository;
import ci.digitalacademyprojet.ecommerce.services.CartService;
import ci.digitalacademyprojet.ecommerce.services.DTO.CartDTO;
import ci.digitalacademyprojet.ecommerce.services.mapper.CartMapper;
import ci.digitalacademyprojet.ecommerce.utils.SlugifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final CartMapper cartMapper;

    @Override
    public CartDTO createCart(CartDTO cartDTO) {
        log.debug("Request to create Cart: {}", cartDTO);
        User user = userRepository.findById(cartDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Cart cart = new Cart();
        cart.setUser(user);
        cart.setSlug(SlugifyUtils.generate(String.valueOf(cartDTO.getUserId())));

        Cart savedCart = cartRepository.save(cart);
        return new CartDTO(savedCart.getId(), user.getId());
    }

    @Override
    public CartDTO getCartById(Long id) {
        log.debug("Request to get Cart with id: {}", id);
        Cart cart = cartRepository.findById(id).orElseThrow(() -> new RuntimeException("Cart not found"));
        return cartMapper.toDto(cart);
    }

    @Override
    public List<CartDTO> getAllCarts() {
        log.debug("Request to get all Carts");
        return cartRepository.findAll().stream()
                .map(cartMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }
}