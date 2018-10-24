package softuni.gamestore.demo.command.commandModels;

import org.springframework.stereotype.Component;
import softuni.gamestore.demo.model.dto.binding.EditGameBindingModel;
import softuni.gamestore.demo.service.gameService.GameService;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Component
@Transactional
public class EditGame implements Command {

    private final GameService gameService;

    public EditGame(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void applay(String[] tokens) {
        Long id = Long.parseLong(tokens[1]);
        BigDecimal price = new BigDecimal(tokens[2].split("=")[1]);
        Double size = Double.parseDouble(tokens[3].split("=")[1]);
        EditGameBindingModel editModel =
                new EditGameBindingModel(id, price, size);

        if (this.gameService.checkForGame(editModel.getId())) {
            String gameTitle = this.gameService.editGame(editModel);
            System.out.println("Edited " + gameTitle);
        } else {
            System.out.println("Game with that id do not exists.");
        }
    }
}
