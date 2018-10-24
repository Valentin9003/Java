package users.system.service;

import users.system.entity.User;

import java.util.Date;
import java.util.List;

public interface UserService {

    void persist(User user);

    List<User> findAllUsersByEmailProvider(String provider);

    List<User> usersLastTimeLoggedInAfter(Date date);

    void removeAllUnActiveUsersAfterDate(Date date);
}
