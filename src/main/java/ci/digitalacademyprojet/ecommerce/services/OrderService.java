package ci.digitalacademyprojet.ecommerce.services;


import ci.digitalacademyprojet.ecommerce.services.DTO.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO createOrder(OrderDTO orderDTO);
    OrderDTO getOrderById(Long id);
    List<OrderDTO> getAllOrders();
    void deleteOrder(Long id);
}