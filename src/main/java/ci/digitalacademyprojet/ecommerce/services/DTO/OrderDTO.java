package ci.digitalacademyprojet.ecommerce.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private Long userId; // Lien vers l'utilisateur
    private BigDecimal totalAmount;
    private String status; // e.g., "pending", "shipped", "cancelled"
    private LocalDateTime createdAt;


}