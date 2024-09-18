package ci.digitalacademyprojet.ecommerce.repositories;


import ci.digitalacademyprojet.ecommerce.models.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
    void deleteByUserId(Long userId);
}