package ci.digitalacademyprojet.ecommerce.web.resources;

import ci.digitalacademyprojet.ecommerce.services.DTO.UserDTO;
import ci.digitalacademyprojet.ecommerce.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserRessource {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        log.debug("REST request to save user {}", userDTO);
        UserDTO newUser = userService.registerUser(userDTO);
        log.info("User successfully registered: {}", newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}