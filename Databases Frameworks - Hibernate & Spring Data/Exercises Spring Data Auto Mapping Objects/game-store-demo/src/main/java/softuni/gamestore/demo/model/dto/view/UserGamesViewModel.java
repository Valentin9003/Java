package softuni.gamestore.demo.model.dto.view;

import softuni.gamestore.demo.model.entity.Game;

import java.util.Set;

public class UserGamesViewModel {

    private Long id;
    private Set<Game> games;

    public UserGamesViewModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
