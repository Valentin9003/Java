package softuni.gamestore.demo.service.gameService;

import softuni.gamestore.demo.model.dto.binding.AddGameBindingModel;
import softuni.gamestore.demo.model.dto.binding.EditGameBindingModel;
import softuni.gamestore.demo.model.dto.view.DetailGameViewModel;
import softuni.gamestore.demo.model.dto.view.GameForDeleteViewModel;
import softuni.gamestore.demo.model.dto.view.ViewGameViewModel;

import java.util.List;
import java.util.Set;

public interface GameService {

    Boolean addGame(AddGameBindingModel model);

    boolean checkForGame(Long id);

    String editGame(EditGameBindingModel editModel);

    void deleteGame(Long id);

    GameForDeleteViewModel findGame(Long id);

    List<ViewGameViewModel> findAllGames();

    DetailGameViewModel getDetailGame(String title);
}
