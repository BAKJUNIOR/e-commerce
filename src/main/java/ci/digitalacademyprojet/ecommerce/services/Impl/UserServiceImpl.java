package ci.digitalacademyprojet.ecommerce.services.Impl;

import ci.digitalacademyprojet.ecommerce.models.RoleUser;
import ci.digitalacademyprojet.ecommerce.models.User;
import ci.digitalacademyprojet.ecommerce.repositories.RoleUserRepository;
import ci.digitalacademyprojet.ecommerce.repositories.UserRepository;
import ci.digitalacademyprojet.ecommerce.repositories.VendorRepository;
import ci.digitalacademyprojet.ecommerce.services.DTO.RoleUserDTO;
import ci.digitalacademyprojet.ecommerce.services.DTO.UserDTO;
import ci.digitalacademyprojet.ecommerce.services.RoleUserService;
import ci.digitalacademyprojet.ecommerce.services.UserService;
import ci.digitalacademyprojet.ecommerce.services.mapper.RoleUserMapper;
import ci.digitalacademyprojet.ecommerce.services.mapper.UserMapper;
import ci.digitalacademyprojet.ecommerce.utils.SlugifyUtils;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleUserMapper roleUserMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JavaMailSender mailSender;
    private final VendorRepository vendorRepository;
    private final RoleUserService roleUserService;


    @Override
    public UserDTO createUser(UserDTO userDTO) {
        log.debug("Request to create user: " + userDTO);
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        // Vérifiez que les rôles existent et associez-les
        Set<RoleUser> roles = new HashSet<>();
        if (userDTO.getRoleUser() != null) {
            for (RoleUserDTO roleUserDTO : userDTO.getRoleUser()) {
                RoleUserDTO roleDTO = roleUserService.findOne(roleUserDTO.getIdRoleUser())
                        .orElseThrow(() -> new EntityNotFoundException("Rôle non trouvé : " + roleUserDTO.getIdRoleUser()));
                RoleUser role = roleUserMapper.toEntity(roleDTO);
                roles.add(role);
            }
        }
        user.setRoleUser(roles);
        user.setSlug(SlugifyUtils.generate(userDTO.getUsername()));
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        User savedUser = userRepository.save(user);
//        sendEmail(user.getEmail(), user.getPassword()); // Envoyer l'email
        return userMapper.toDto(savedUser);
    }

    private void sendEmail(String email, String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Votre inscription");
        message.setText("Bienvenue ! Voici votre mot de passe : " + password);
        mailSender.send(message);
    }


    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Long userId) {
        vendorRepository.deleteByUserId(userId);
        userRepository.deleteById(userId);
    }
}