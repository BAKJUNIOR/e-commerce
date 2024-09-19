package ci.digitalacademyprojet.ecommerce.web.resources;

import ci.digitalacademyprojet.ecommerce.services.DTO.PaymentDTO;
import ci.digitalacademyprojet.ecommerce.services.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentDTO> createPayment(@RequestBody PaymentDTO paymentDTO) {
        log.debug("REST request to create payment {}", paymentDTO);
        PaymentDTO createdPayment = paymentService.createPayment(paymentDTO);
        log.debug("Payment created successfully {}", createdPayment);
        return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable Long id) {
        log.debug("REST request to get payment by id {}", id);
        PaymentDTO paymentDTO = paymentService.getPaymentById(id);
        log.debug("Payment fetched successfully {}", paymentDTO);
        return ResponseEntity.ok(paymentDTO);
    }

    @GetMapping
    public ResponseEntity<List<PaymentDTO>> getAllPayments() {
        log.debug("REST request to get all payments");
        List<PaymentDTO> payments = paymentService.getAllPayments();
        log.debug("Total payments fetched: {}", payments.size());
        return ResponseEntity.ok(payments);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        log.debug("REST request to delete payment with id {}", id);
        paymentService.deletePayment(id);
        log.debug("Payment with id {} deleted successfully", id);
        return ResponseEntity.noContent().build();
    }
}