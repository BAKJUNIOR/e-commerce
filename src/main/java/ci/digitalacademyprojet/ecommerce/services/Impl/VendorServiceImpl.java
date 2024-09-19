package ci.digitalacademyprojet.ecommerce.services.Impl;
import ci.digitalacademyprojet.ecommerce.models.User;
import ci.digitalacademyprojet.ecommerce.models.Vendor;
import ci.digitalacademyprojet.ecommerce.repositories.UserRepository;
import ci.digitalacademyprojet.ecommerce.repositories.VendorRepository;
import ci.digitalacademyprojet.ecommerce.services.DTO.VendorDTO;
import ci.digitalacademyprojet.ecommerce.services.VendorService;
import ci.digitalacademyprojet.ecommerce.services.mapper.VendorMapper;
import ci.digitalacademyprojet.ecommerce.utils.SlugifyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;
    private final UserRepository userRepository;

    private final VendorMapper vendorMapper;

    @Override
    public VendorDTO createVendor(VendorDTO vendorDTO) {
        Vendor vendor = vendorMapper.toEntity(vendorDTO);

        // Récupérer l'utilisateur à partir de l'ID
        User user = userRepository.findById(vendorDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        vendor.setUser(user); // Associez l'utilisateur au vendeur
        vendor.setSlug(SlugifyUtils.generate(vendorDTO.getName()));
        Vendor savedVendor = vendorRepository.save(vendor);
        return vendorMapper.toDto(savedVendor);
    }
    @Override
    public VendorDTO getVendorById(Long id) {
        Vendor vendor = vendorRepository.findById(id).orElseThrow(() -> new RuntimeException("Vendor not found"));
        return vendorMapper.toDto(vendor);
    }

    @Override
    public List<VendorDTO> getAllVendors() {
        return vendorRepository.findAll().stream()
                .map(vendorMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }
}