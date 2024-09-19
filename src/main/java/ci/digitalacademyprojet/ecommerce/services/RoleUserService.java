package ci.digitalacademyprojet.ecommerce.services;




import ci.digitalacademyprojet.ecommerce.services.DTO.RoleUserDTO;

import java.util.List;
import java.util.Optional;

public interface RoleUserService {
    RoleUserDTO save(RoleUserDTO roleUserDTO);
    RoleUserDTO update(RoleUserDTO roleUserDTO);
    void delete(Long id);
    List<RoleUserDTO> getAll();
    Optional<RoleUserDTO> findOne(Long id);

    List<RoleUserDTO> findByRole(String roleUser);
    List<RoleUserDTO> findAll();
}
