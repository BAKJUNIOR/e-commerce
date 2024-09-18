package ci.digitalacademyprojet.ecommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order; // Le paiement est lié à une commande

    private BigDecimal amount;
    private String paymentMethod; // e.g., "credit card", "PayPal"
    private String status; // e.g., "successful", "failed", "pending"
    private String transactionId; // ID de transaction du service de paiement
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}