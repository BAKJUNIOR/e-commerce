package ci.digitalacademyprojet.ecommerce.services;


import ci.digitalacademyprojet.ecommerce.services.DTO.UserDTO;
import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUsers();
    void deleteUser(Long id);
}