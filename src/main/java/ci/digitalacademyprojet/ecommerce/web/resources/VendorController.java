package ci.digitalacademyprojet.ecommerce.web.resources;

import ci.digitalacademyprojet.ecommerce.services.DTO.VendorDTO;
import ci.digitalacademyprojet.ecommerce.services.VendorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/vendors")
public class VendorController {
    private final VendorService vendorService;

    @PostMapping
    public ResponseEntity<VendorDTO> createVendor(@RequestBody VendorDTO vendorDTO) {
        log.debug("REST request to create vendor {}", vendorDTO);
        VendorDTO createdVendor = vendorService.createVendor(vendorDTO);
        log.debug("Vendor created successfully {}", createdVendor);
        return new ResponseEntity<>(createdVendor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendorDTO> getVendorById(@PathVariable Long id) {
        log.debug("REST request to get vendor by id {}", id);
        VendorDTO vendorDTO = vendorService.getVendorById(id);
        log.debug("Vendor fetched successfully {}", vendorDTO);
        return ResponseEntity.ok(vendorDTO);
    }

    @GetMapping
    public ResponseEntity<List<VendorDTO>> getAllVendors() {
        log.debug("REST request to get all vendors");
        List<VendorDTO> vendors = vendorService.getAllVendors();
        log.debug("Total vendors fetched: {}", vendors.size());
        return ResponseEntity.ok(vendors);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVendor(@PathVariable Long id) {
        log.debug("REST request to delete vendor with id {}", id);
        vendorService.deleteVendor(id);
        log.debug("Vendor with id {} deleted successfully", id);
        return ResponseEntity.noContent().build();
    }
}