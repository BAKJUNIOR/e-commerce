package ci.digitalacademyprojet.ecommerce.web.resources;

import ci.digitalacademyprojet.ecommerce.services.DTO.UserDTO;
import ci.digitalacademyprojet.ecommerce.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        log.debug("REST request to create user {}", userDTO);
        UserDTO createdUser = userService.createUser(userDTO);
        log.debug("User created successfully {}", createdUser);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        log.debug("REST request to get user by id {}", id);
        UserDTO userDTO = userService.getUserById(id);
        log.debug("User fetched successfully {}", userDTO);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        log.debug("REST request to get all users");
        List<UserDTO> users = userService.getAllUsers();
        log.debug("Total users fetched: {}", users.size());
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        log.debug("REST request to delete user with id {}", id);
        userService.deleteUser(id);
        log.debug("User with id {} deleted successfully", id);
        return ResponseEntity.noContent().build();
    }
}