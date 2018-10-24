package softuni.gamestore.demo.service.roleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.gamestore.demo.model.entity.Role;
import softuni.gamestore.demo.repository.RoleRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleByName(Roles role) {
        return this.roleRepository.findByName(role.name());
    }

    @Override
    public void updateRole(Role role) {
        this.roleRepository.saveAndFlush(role);
    }
}
