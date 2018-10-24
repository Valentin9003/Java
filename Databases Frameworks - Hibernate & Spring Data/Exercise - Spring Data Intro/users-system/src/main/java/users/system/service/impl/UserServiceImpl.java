package users.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import users.system.entity.User;
import users.system.repositories.UserRepo;
import users.system.service.interfaces.UserService;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void persist(User user) {
        this.userRepo.save(user);
    }

    @Override
    public List<User> findAllUsersByEmailProvider(String provider) {
        return this.userRepo.findAllByEmailContains(provider);
    }

    @Override
    public List<User> usersLastTimeLoggedInAfter(Date date) {
        return this.userRepo.findAllByLastTimeLoggedInAfter(date);
    }

    @Override
    public void removeAllUnActiveUsersAfterDate(Date date) {
        this.userRepo.removeAllUnActiveUsersAfterDate(date);
    }

    @Override
    public void deleteAllByIsDeletedTrue() {
        this.userRepo.deleteAllByIsDeletedTrue();
    }

}
