package users.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import users.system.entity.User;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    List<User> findAllByEmailContains(String provider);

    List<User> findAllByLastTimeLoggedInAfter(Date date);

    @Modifying
    @Query(value = "UPDATE User u SET u.deleted = true WHERE u.lastTimeLoggedIn > :date")
    void removeAllUnActiveUsersAfterDate(@Param("date") Date date);

    @Modifying
    @Query(value = "DELETE FROM User u WHERE u.deleted = true")
    void deleteAllByIsDeletedTrue();
}
