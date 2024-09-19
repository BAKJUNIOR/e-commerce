package ci.digitalacademyprojet.ecommerce.services.Impl;

import ci.digitalacademyprojet.ecommerce.models.Order;
import ci.digitalacademyprojet.ecommerce.models.Payment;
import ci.digitalacademyprojet.ecommerce.repositories.OrderRepository;
import ci.digitalacademyprojet.ecommerce.repositories.PaymentRepository;
import ci.digitalacademyprojet.ecommerce.services.DTO.PaymentDTO;
import ci.digitalacademyprojet.ecommerce.services.PaymentService;
import ci.digitalacademyprojet.ecommerce.services.mapper.PaymentMapper;
import ci.digitalacademyprojet.ecommerce.utils.SlugifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
private  final  EmailService emailService;
    private final PaymentMapper paymentMapper;

    @Override
    public PaymentDTO createPayment(PaymentDTO paymentDTO) {
        log.debug("Request to create payment:{}", paymentDTO);
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
        payment.setSlug(SlugifyUtils.generate(paymentDTO.getPaymentMethod()));
        // Initialiser les dates
        LocalDateTime now = LocalDateTime.now();
        payment.setCreatedAt(now); // Date de création
        payment.setUpdatedAt(now); // Date de mise à jour initiale

        // Enregistrer le paiement
        Payment savedPayment = paymentRepository.save(payment);
        sendPaymentConfirmationEmail(order);

        paymentDTO.setId(savedPayment.getId());
        paymentDTO.setCreatedAt(savedPayment.getCreatedAt());
        paymentDTO.setUpdatedAt(savedPayment.getUpdatedAt());

        return paymentDTO;
    }

    private void sendPaymentConfirmationEmail(Order order) {
        String email = order.getUser().getEmail();
        String orderDetails = "Détails de votre commande :\n"
                + "Commande ID: " + order.getId() + "\n"
                + "Montant: " + order.getTotalAmount() + "\n"
                + "Statut: " + order.getStatus() + "\n";

        emailService.sendOrderConfirmationEmail(email, orderDetails);
}

    @Override
    public PaymentDTO getPaymentById(Long id) {
        log.debug("Request to get payment by id:{}", id);
        Payment payment = paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment not found"));
        return paymentMapper.toDto(payment);
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        log.debug("Request to get all payments");
        return paymentRepository.findAll().stream()
                .map(paymentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }


}