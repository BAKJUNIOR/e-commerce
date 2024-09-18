package ci.digitalacademyprojet.ecommerce.services;


import ci.digitalacademyprojet.ecommerce.services.DTO.CartItemDTO;

import java.util.List;

public interface CartItemService {
    CartItemDTO createCartItem(CartItemDTO cartItemDTO);
    CartItemDTO getCartItemById(Long id);
    List<CartItemDTO> getAllCartItems();
    void deleteCartItem(Long id);
}