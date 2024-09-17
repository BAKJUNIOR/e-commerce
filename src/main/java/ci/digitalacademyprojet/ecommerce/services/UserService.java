package ci.digitalacademyprojet.ecommerce.services;


import ci.digitalacademyprojet.ecommerce.services.DTO.UserDTO;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO);
    // D'autres méthodes peuvent être ajoutées ici
}