package softuni.gamestore.demo.command.commandModels;

import org.springframework.stereotype.Component;
import softuni.gamestore.demo.model.dto.binding.UserLogoutBindingModel;
import softuni.gamestore.demo.model.dto.view.SuccessLogoutUserViewModel;
import softuni.gamestore.demo.service.userService.UserService;

import javax.transaction.Transactional;

@Component
@Transactional
public class LogoutUser implements Command {

    private final UserService userService;

    public LogoutUser(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void applay(String[] tokens) {
        UserLogoutBindingModel logoutModel = new UserLogoutBindingModel(tokens[1]);
        SuccessLogoutUserViewModel suvModel = this.userService.logout(logoutModel);
        if (suvModel != null) {
            System.out.println("User " + suvModel.getFullName() + " successfully logged out");
        } else {
            System.out.println("Cannot log out. No user was logged in.");
        }
    }
}
