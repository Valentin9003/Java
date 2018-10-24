package softuni.gamestore.demo.command.commandModels;

import org.springframework.stereotype.Component;
import softuni.gamestore.demo.model.dto.binding.UserLoginBindingModel;
import softuni.gamestore.demo.model.dto.view.SuccessLoginUserViewModel;
import softuni.gamestore.demo.service.userService.UserService;

import javax.transaction.Transactional;

@Component
@Transactional
public class LoginUser implements Command {

    private final UserService userService;

    public LoginUser(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void applay(String[] tokens) {
        UserLoginBindingModel loginModel = new UserLoginBindingModel(tokens[1], tokens[2]);
        SuccessLoginUserViewModel successLoginUserViewModel = this.userService.login(loginModel);

        if (successLoginUserViewModel != null) {
            System.out.println("Successfully logged in " + successLoginUserViewModel.getFullName());
        }
    }
}
