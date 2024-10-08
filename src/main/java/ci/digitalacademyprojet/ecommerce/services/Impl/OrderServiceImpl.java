package ci.digitalacademyprojet.ecommerce.services.Impl;

import ci.digitalacademyprojet.ecommerce.models.Order;
import ci.digitalacademyprojet.ecommerce.models.User;
import ci.digitalacademyprojet.ecommerce.repositories.OrderRepository;
import ci.digitalacademyprojet.ecommerce.repositories.UserRepository;
import ci.digitalacademyprojet.ecommerce.services.DTO.OrderDTO;
import ci.digitalacademyprojet.ecommerce.services.OrderService;
import ci.digitalacademyprojet.ecommerce.services.mapper.OrderMapper;
import ci.digitalacademyprojet.ecommerce.utils.SlugifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    private final OrderMapper orderMapper;

    @Override
    @Transactional
    public OrderDTO createOrder(OrderDTO orderDTO) {
        log.debug("Request to create order:{}", orderDTO);
        // Récupérer l'utilisateur à partir de l'ID
        User user = userRepository.findById(orderDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        LocalDateTime now = LocalDateTime.now();
        Order order = new Order();
        order.setUser(user);
        order.setCreatedAt(now);
        order.setTotalAmount(orderDTO.getTotalAmount());
        order.setStatus(orderDTO.getStatus());
        order.setSlug(SlugifyUtils.generate(orderDTO.getStatus()));
        // Enregistrer la commande
        Order savedOrder = orderRepository.save(order);
        return orderDTO;
    }



    @Override
    public OrderDTO getOrderById(Long id) {
        log.debug("Request to get order by id:{}", id);
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        return orderMapper.toDto(order);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        log.debug("Request to get all orders");
        return orderRepository.findAll().stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}