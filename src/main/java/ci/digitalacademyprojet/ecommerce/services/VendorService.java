package ci.digitalacademyprojet.ecommerce.services;


import ci.digitalacademyprojet.ecommerce.services.DTO.VendorDTO;

import java.util.List;

public interface VendorService {
    VendorDTO createVendor(VendorDTO vendorDTO);
    VendorDTO getVendorById(Long id);
    List<VendorDTO> getAllVendors();
    void deleteVendor(Long id);
}