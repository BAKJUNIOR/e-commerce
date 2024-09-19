package ci.digitalacademyprojet.ecommerce.web.resources;

import ci.digitalacademyprojet.ecommerce.services.DTO.OrderItemDTO;
import ci.digitalacademyprojet.ecommerce.services.OrderItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @PostMapping
    public ResponseEntity<OrderItemDTO> createOrderItem(@RequestBody OrderItemDTO orderItemDTO) {
        log.debug("REST request to create order item {}", orderItemDTO);
        OrderItemDTO createdOrderItem = orderItemService.createOrderItem(orderItemDTO);
        log.debug("Order item created successfully {}", createdOrderItem);
        return new ResponseEntity<>(createdOrderItem, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemDTO> getOrderItemById(@PathVariable Long id) {
        log.debug("REST request to get order item by id {}", id);
        OrderItemDTO orderItemDTO = orderItemService.getOrderItemById(id);
        log.debug("Order item fetched successfully {}", orderItemDTO);
        return ResponseEntity.ok(orderItemDTO);
    }

    @GetMapping
    public ResponseEntity<List<OrderItemDTO>> getAllOrderItems() {
        log.debug("REST request to get all order items");
        List<OrderItemDTO> orderItems = orderItemService.getAllOrderItems();
        log.debug("Total order items fetched: {}", orderItems.size());
        return ResponseEntity.ok(orderItems);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        log.debug("REST request to delete order item with id {}", id);
        orderItemService.deleteOrderItem(id);
        log.debug("Order item with id {} deleted successfully", id);
        return ResponseEntity.noContent().build();
    }
}