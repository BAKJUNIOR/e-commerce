package ci.digitalacademyprojet.ecommerce.services.Impl;

import ci.digitalacademyprojet.ecommerce.models.User;
import ci.digitalacademyprojet.ecommerce.models.enums.Role;
import ci.digitalacademyprojet.ecommerce.repositories.UserRepository;
import ci.digitalacademyprojet.ecommerce.services.DTO.UserDTO;
import ci.digitalacademyprojet.ecommerce.services.UserService;
import ci.digitalacademyprojet.ecommerce.services.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);

        // Hachage du mot de passe
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Attribution du rôle par défaut si non spécifié
        if (user.getRole() == null) {
            user.setRole(Role.CLIENT); // Rôle par défaut
        }

        user = userRepository.save(user); // Sauvegarde de l'utilisateur
        return userMapper.toDto(user); // Retourne le DTO de l'utilisateur
    }

}