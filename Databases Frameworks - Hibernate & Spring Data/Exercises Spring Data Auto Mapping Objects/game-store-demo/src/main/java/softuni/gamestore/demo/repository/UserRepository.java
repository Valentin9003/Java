package softuni.gamestore.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.gamestore.demo.model.entity.Role;
import softuni.gamestore.demo.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByEmail(String email);

    @Query(value = "SELECT u.role FROM User u WHERE u.email = :mail")
    Role findUserRoleByEmail(@Param("mail") String email);

}
