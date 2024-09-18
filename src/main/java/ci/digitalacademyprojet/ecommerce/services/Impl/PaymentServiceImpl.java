package ci.digitalacademyprojet.ecommerce.services.Impl;

import ci.digitalacademyprojet.ecommerce.models.Order;
import ci.digitalacademyprojet.ecommerce.models.Payment;
import ci.digitalacademyprojet.ecommerce.repositories.OrderRepository;
import ci.digitalacademyprojet.ecommerce.repositories.PaymentRepository;
import ci.digitalacademyprojet.ecommerce.services.DTO.PaymentDTO;
import ci.digitalacademyprojet.ecommerce.services.PaymentService;
import ci.digitalacademyprojet.ecommerce.services.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    private final PaymentMapper paymentMapper;

    @Override
    public PaymentDTO createPayment(PaymentDTO paymentDTO) {
        // Récupérer la commande à partir de l'ID
        Order order = orderRepository.findById(paymentDTO.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        // Créer le paiement
        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setAmount(paymentDTO.getAmount());
        payment.setPaymentMethod(paymentDTO.getPaymentMethod());
        payment.setStatus(paymentDTO.getStatus());
        payment.setTransactionId(paymentDTO.getTransactionId());

        // Initialiser les dates
        LocalDateTime now = LocalDateTime.now();
        payment.setCreatedAt(now); // Date de création
        payment.setUpdatedAt(now); // Date de mise à jour initiale

        // Enregistrer le paiement
        Payment savedPayment = paymentRepository.save(payment);

        paymentDTO.setId(savedPayment.getId());
        paymentDTO.setCreatedAt(savedPayment.getCreatedAt());
        paymentDTO.setUpdatedAt(savedPayment.getUpdatedAt());

        return paymentDTO;
    }

    @Override
    public PaymentDTO getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment not found"));
        return paymentMapper.toDto(payment);
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll().stream()
                .map(paymentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }


}