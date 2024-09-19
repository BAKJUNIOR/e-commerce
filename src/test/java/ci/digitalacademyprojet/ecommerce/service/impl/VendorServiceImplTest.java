package ci.digitalacademyprojet.ecommerce.service.impl;

import ci.digitalacademyprojet.ecommerce.models.User;
import ci.digitalacademyprojet.ecommerce.models.Vendor;
import ci.digitalacademyprojet.ecommerce.repositories.VendorRepository;
import ci.digitalacademyprojet.ecommerce.services.DTO.VendorDTO;
import ci.digitalacademyprojet.ecommerce.services.Impl.VendorServiceImpl;
import ci.digitalacademyprojet.ecommerce.services.VendorService;
import ci.digitalacademyprojet.ecommerce.services.mapper.VendorMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

@SpringBootTest
public class VendorServiceImplTest {
    @Mock
    private VendorRepository vendorRepository;

    @Mock
    private VendorMapper vendorMapper;
    @InjectMocks
    private VendorServiceImpl vendorService ;

    @Test
    public void whenGetVendorById_thenReturnVendor(){
     when(vendorRepository.findById(50L)).thenReturn(Optional.of(new Vendor(50L, "Bakus", "Vendeur de produit bio",new User())));
        VendorDTO vendor = vendorService.getVendorById(50L);
        assertNotNull(String.valueOf(vendor),"vendor not null");
    }
}
