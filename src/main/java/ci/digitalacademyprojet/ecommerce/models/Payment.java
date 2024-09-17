package ci.digitalacademyprojet.ecommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order; // Relation avec la commande

    @Column(nullable = false)
    private Double amount; // Montant du paiement

    @Column(nullable = false)
    private LocalDateTime paymentDate; // Date et heure du paiement

    @Column(nullable = false)
    private String paymentMethod; // Méthode de paiement (ex. : Carte, PayPal)

    @Column(nullable = false)
    private String status; // Statut du paiement (ex. : Réussi, Échoué)
}