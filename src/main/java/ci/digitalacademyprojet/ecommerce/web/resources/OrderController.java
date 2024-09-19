package ci.digitalacademyprojet.ecommerce.web.resources;

import ci.digitalacademyprojet.ecommerce.services.DTO.OrderDTO;
import ci.digitalacademyprojet.ecommerce.services.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        log.debug("REST request to create order {}", orderDTO);
        OrderDTO createdOrder = orderService.createOrder(orderDTO);
        log.debug("Order created successfully {}", createdOrder);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
        log.debug("REST request to get order by id {}", id);
        OrderDTO orderDTO = orderService.getOrderById(id);
        log.debug("Order fetched successfully {}", orderDTO);
        return ResponseEntity.ok(orderDTO);
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        log.debug("REST request to get all orders");
        List<OrderDTO> orders = orderService.getAllOrders();
        log.debug("Total orders fetched: {}", orders.size());
        return ResponseEntity.ok(orders);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        log.debug("REST request to delete order with id {}", id);
        orderService.deleteOrder(id);
        log.debug("Order with id {} deleted successfully", id);
        return ResponseEntity.noContent().build();
    }
}