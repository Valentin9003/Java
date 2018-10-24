package softuni.gamestore.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.gamestore.demo.model.entity.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    Game findByTitle(String title);
}
