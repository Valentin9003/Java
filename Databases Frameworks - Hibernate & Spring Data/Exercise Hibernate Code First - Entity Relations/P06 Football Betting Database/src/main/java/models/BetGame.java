package models;

import javax.persistence.*;

@Entity
@Table(name = "bet_games")
public class BetGame {

    private Long id;
    private Game game;
    private Bet bet;
    private ResultPrediction resultPrediction;

    public BetGame() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_betgame_game"))
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bet_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_betgame_bet"))
    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "result_prediction", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_betgame_resultp"))
    public ResultPrediction getResultPrediction() {
        return resultPrediction;
    }

    public void setResultPrediction(ResultPrediction resultPrediction) {
        this.resultPrediction = resultPrediction;
    }
}
