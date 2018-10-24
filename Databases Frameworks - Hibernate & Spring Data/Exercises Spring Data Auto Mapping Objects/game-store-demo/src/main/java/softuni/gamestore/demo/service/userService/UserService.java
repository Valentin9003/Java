package softuni.gamestore.demo.service.userService;

import softuni.gamestore.demo.model.dto.binding.UserLoginBindingModel;
import softuni.gamestore.demo.model.dto.binding.UserLogoutBindingModel;
import softuni.gamestore.demo.model.dto.binding.UserRegisterBindingModel;
import softuni.gamestore.demo.model.dto.view.SuccessLoginUserViewModel;
import softuni.gamestore.demo.model.dto.view.SuccessLogoutUserViewModel;
import softuni.gamestore.demo.model.dto.view.UserGamesViewModel;

public interface UserService {

    boolean register(UserRegisterBindingModel model);

    SuccessLoginUserViewModel login(UserLoginBindingModel model);

    SuccessLogoutUserViewModel logout(UserLogoutBindingModel logoutModel);

    Boolean isADMIN(String email);

    UserLogoutBindingModel loginUser(String email);

    UserGamesViewModel getUserGamesViewModel(String email);
}
