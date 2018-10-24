package softuni.gamestore.demo.service.gameService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.gamestore.demo.model.dto.view.DetailGameViewModel;
import softuni.gamestore.demo.util.ObjectMapperUtils;
import softuni.gamestore.demo.model.dto.binding.AddGameBindingModel;
import softuni.gamestore.demo.model.dto.binding.EditGameBindingModel;
import softuni.gamestore.demo.model.dto.view.GameForDeleteViewModel;
import softuni.gamestore.demo.model.dto.view.ViewGameViewModel;
import softuni.gamestore.demo.model.entity.Game;
import softuni.gamestore.demo.repository.GameRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean addGame(AddGameBindingModel model) {
//        Game game1 = modelMapper.map(model, Game.class);
        Game game = ObjectMapperUtils.map(model, Game.class);
        game = this.gameRepository.save(game);
        return game.getId() != null;
    }

    @Override
    public boolean checkForGame(Long id) {
        return this.gameRepository.existsById(id);
    }

    @Override
    public String editGame(EditGameBindingModel editModel) {
        Game game = this.gameRepository.getOne(editModel.getId());
        game.setPrice(editModel.getPrice());
        game.setSize(editModel.getSize());
        return game.getTitle();
    }

    @Override
    public void deleteGame(Long id) {
        this.gameRepository.deleteById(id);
    }

    @Override
    public GameForDeleteViewModel findGame(Long id) {
        Game game = this.gameRepository.getOne(id);
        return modelMapper.map(game, GameForDeleteViewModel.class);
    }

    @Override
    public List<ViewGameViewModel> findAllGames() {
        List<Game> gameList = this.gameRepository.findAll();
        return ObjectMapperUtils.mapAll(gameList, ViewGameViewModel.class);
    }

    @Override
    public DetailGameViewModel getDetailGame(String title) {
        Game game = this.gameRepository.findByTitle(title);
        DetailGameViewModel viewModel = ObjectMapperUtils.map(game, DetailGameViewModel.class);
        return viewModel;
    }
}
