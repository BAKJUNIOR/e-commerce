package ci.digitalacademyprojet.ecommerce.services.Impl;

import ci.digitalacademyprojet.ecommerce.models.Order;
import ci.digitalacademyprojet.ecommerce.models.OrderItem;
import ci.digitalacademyprojet.ecommerce.models.Product;
import ci.digitalacademyprojet.ecommerce.repositories.OrderItemRepository;
import ci.digitalacademyprojet.ecommerce.repositories.OrderRepository;
import ci.digitalacademyprojet.ecommerce.repositories.ProductRepository;
import ci.digitalacademyprojet.ecommerce.services.DTO.OrderItemDTO;
import ci.digitalacademyprojet.ecommerce.services.OrderItemService;
import ci.digitalacademyprojet.ecommerce.services.mapper.OrderItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    private final OrderItemMapper orderItemMapper;

    @Override
    public OrderItemDTO createOrderItem(OrderItemDTO orderItemDTO) {
        Order order = orderRepository.findById(orderItemDTO.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Product product = productRepository.findById(orderItemDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Créer l'élément de commande
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setQuantity(orderItemDTO.getQuantity());
        orderItem.setPrice(orderItemDTO.getPrice());

        // Enregistrer l'élément de commande
        OrderItem savedOrderItem = orderItemRepository.save(orderItem);
        return new OrderItemDTO(savedOrderItem.getId(), order.getId(), product.getId(), savedOrderItem.getQuantity(), savedOrderItem.getPrice());
    }

    @Override
    public OrderItemDTO getOrderItemById(Long id) {
        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderItem not found"));
        return new OrderItemDTO(orderItem.getId(), orderItem.getOrder().getId(), orderItem.getProduct().getId(), orderItem.getQuantity(), orderItem.getPrice());
    }


    @Override
    public List<OrderItemDTO> getAllOrderItems() {
        return orderItemRepository.findAll().stream()
                .map(orderItemMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}