package softuni.gamestore.demo.command.commandModels;

import softuni.gamestore.demo.model.dto.view.ViewGameViewModel;
import softuni.gamestore.demo.service.gameService.GameService;

import java.util.List;

public class AllGames implements Command {

    private final GameService gameService;

    public AllGames(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void applay(String[] tokens) {
        List<ViewGameViewModel> viewModels = this.gameService.findAllGames();
        viewModels.forEach( m ->
                System.out.println(String.format("%s %.2f", m.getTitle(), m.getPrice())));
    }
}
