package ci.digitalacademyprojet.ecommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order; // Un élément appartient à une commande

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product; // Un élément est un produit

    private int quantity;
    private BigDecimal price; // Prix du produit au moment de la commande

}