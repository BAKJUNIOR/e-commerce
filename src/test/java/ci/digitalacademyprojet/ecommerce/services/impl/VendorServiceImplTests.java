package ci.digitalacademyprojet.ecommerce.services.impl;

import ci.digitalacademyprojet.ecommerce.models.Vendor;
import ci.digitalacademyprojet.ecommerce.repositories.VendorRepository;
import ci.digitalacademyprojet.ecommerce.services.DTO.VendorDTO;
import ci.digitalacademyprojet.ecommerce.services.Impl.VendorServiceImpl;
import ci.digitalacademyprojet.ecommerce.services.VendorService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class VendorServiceImplTests {

    @Mock
    private VendorRepository vendorRepository;

    @InjectMocks
    private VendorServiceImpl vendorService;
    @Test
    public void whenGetVendorById_thenReturnVendor(){
        when(vendorRepository.findById(50L)).thenReturn(Optional.of(new Vendor(50L,"KONE","vendeuse d'alloco",null)));
        VendorDTO vendor = vendorService.getVendorById(50L);
        assertNotNull(vendor,"vendor not null");
    }
}
