package ci.digitalacademyprojet.ecommerce.services;


import ci.digitalacademyprojet.ecommerce.services.DTO.CartDTO;

import java.util.List;

public interface CartService {
    CartDTO createCart(CartDTO cartDTO);
    CartDTO getCartById(Long id);
    List<CartDTO> getAllCarts();
    void deleteCart(Long id);
}