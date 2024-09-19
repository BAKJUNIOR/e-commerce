package ci.digitalacademyprojet.ecommerce;

import ci.digitalacademyprojet.ecommerce.models.RoleUser;
import ci.digitalacademyprojet.ecommerce.repositories.RoleUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.net.ssl.*;
import java.security.cert.X509Certificate;

@RequiredArgsConstructor
@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner {

    private final RoleUserRepository roleUserRepository;

    public static void main(String[] args) {

        SpringApplication.run(ECommerceApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        createRoles();
    }

    private void createRoles() {
        if (roleUserRepository.count() == 0) {
            RoleUser adminRole = new RoleUser();
            adminRole.setIdRoleUser(1L);
            adminRole.setNameRole("ADMIN");

            RoleUser clientRole = new RoleUser();
            clientRole.setIdRoleUser(2L);
            clientRole.setNameRole("CLIENT");

            RoleUser vendorRole = new RoleUser();
            vendorRole.setIdRoleUser(3L);
            vendorRole.setNameRole("VENDOR");

            roleUserRepository.save(adminRole);
            roleUserRepository.save(clientRole);
            roleUserRepository.save(vendorRole);
            System.out.println("Roles created successfully.");
        } else {
            System.out.println("Roles already exist in the database.");
        }
    }

}