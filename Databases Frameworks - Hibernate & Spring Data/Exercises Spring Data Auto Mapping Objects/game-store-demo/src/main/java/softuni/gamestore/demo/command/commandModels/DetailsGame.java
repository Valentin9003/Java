package softuni.gamestore.demo.command.commandModels;

import softuni.gamestore.demo.model.dto.view.DetailGameViewModel;
import softuni.gamestore.demo.service.gameService.GameService;

public class DetailsGame implements Command {

    private final GameService gameService;

    public DetailsGame(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void applay(String[] tokens) {
        String title = tokens[1];
        DetailGameViewModel viewModel = this.gameService.getDetailGame(title);
        if (viewModel != null) {
            System.out.println(viewModel);
        } else {
            System.out.println("Don't exist game with this title.DetailGame|Overwatch");
        }
    }
}
