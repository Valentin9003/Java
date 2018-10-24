package softuni.gamestore.demo.command.commandModels;

import org.springframework.stereotype.Component;
import softuni.gamestore.demo.model.dto.binding.UserRegisterBindingModel;
import softuni.gamestore.demo.service.userService.UserService;

import javax.transaction.Transactional;

@Component
@Transactional
public class RegisterUser implements Command {

    private final UserService userService;

    public RegisterUser(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void applay(String tokens[]) {
        UserRegisterBindingModel registerModel =
                new UserRegisterBindingModel(tokens[1], tokens[2], tokens[3], tokens[4]);
        boolean isRegistered = this.userService.register(registerModel);

        if (isRegistered) {
            System.out.println(registerModel.getFullName() + " was registered");
        }
    }
}
