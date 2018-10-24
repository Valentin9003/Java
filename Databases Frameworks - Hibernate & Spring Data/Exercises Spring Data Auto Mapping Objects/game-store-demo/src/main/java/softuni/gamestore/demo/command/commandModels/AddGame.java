package softuni.gamestore.demo.command.commandModels;

import org.springframework.stereotype.Component;
import softuni.gamestore.demo.model.dto.binding.AddGameBindingModel;
import softuni.gamestore.demo.service.gameService.GameService;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Transactional
@Component
public class AddGame implements Command {

    private final GameService gameService;

    public AddGame(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void applay(String[] tokens) {
        String title = tokens[1];
        BigDecimal price = new BigDecimal(tokens[2]);
        Double size = Double.parseDouble(tokens[3]);
        String youtobeId = tokens[4];
        String imageUrl = tokens[5];
        String description = tokens[6];
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date releaseDate = null;
        try {
            releaseDate = sdf.parse(tokens[7]);
        } catch (Exception ignored) {}

        AddGameBindingModel gameModel =
                new AddGameBindingModel(title, price, size, youtobeId, imageUrl, description, releaseDate);
        boolean isAdded = this.gameService.addGame(gameModel);

        if (isAdded) {
            System.out.println(String.format("Added %s%n", gameModel.getTitle()));
        }
    }
}
