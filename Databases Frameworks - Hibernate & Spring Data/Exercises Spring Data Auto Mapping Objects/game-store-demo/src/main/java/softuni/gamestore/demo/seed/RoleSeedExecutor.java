package softuni.gamestore.demo.seed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import softuni.gamestore.demo.model.entity.Role;
import softuni.gamestore.demo.repository.RoleRepository;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class RoleSeedExecutor {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleSeedExecutor(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    /** After u create instance from this class @PostConstruct will be called auto
     * and this method will insert automatic our roles*/
    public void insertRole() {
        if (this.roleRepository.count() == 0L) {
            Role adminRole = new Role();
            adminRole.setName("ADMIN");
            Role userRole = new Role();
            userRole.setName("USER");

            this.roleRepository.saveAll(Arrays.asList(adminRole, userRole));
        }
    }
}
