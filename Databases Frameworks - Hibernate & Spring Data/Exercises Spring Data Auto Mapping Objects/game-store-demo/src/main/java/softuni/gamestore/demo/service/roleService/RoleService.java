package softuni.gamestore.demo.service.roleService;

import softuni.gamestore.demo.model.entity.Role;

public interface RoleService {

    Role getRoleByName(Roles role);

    void updateRole(Role role);

    enum Roles {
        ADMIN, USER
    }
}
