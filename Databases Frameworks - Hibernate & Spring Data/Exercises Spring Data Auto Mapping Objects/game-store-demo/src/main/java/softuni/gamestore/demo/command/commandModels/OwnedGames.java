package softuni.gamestore.demo.command.commandModels;

import org.springframework.stereotype.Component;
import softuni.gamestore.demo.model.dto.view.UserGamesViewModel;
import softuni.gamestore.demo.model.entity.Game;
import softuni.gamestore.demo.service.userService.UserService;

import javax.transaction.Transactional;

@Component
@Transactional
public class OwnedGames implements Command {

    private final UserService userService;

    public OwnedGames(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void applay(String[] token) {
        String email = token[1];
        UserGamesViewModel viewModel = this.userService.getUserGamesViewModel(email);
        for (Game game : viewModel.getGames()) {
            System.out.println(game.getTitle());
        }
    }
}
