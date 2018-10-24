package models;

import javax.persistence.*;

@Entity
@Table(name = "players_tatistics")
public class PlayerStatistics {

    private Long id;
    private Game game;
    private Player player;
    private Integer scoredGoals;
    private Integer playerAssists;
    private Integer playedMinutes;

    public PlayerStatistics() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_ps_game"))
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_ps_player"))
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Column(name = "scored_goals")
    public Integer getScoredGoals() {
        return scoredGoals;
    }

    public void setScoredGoals(Integer scoredGoals) {
        this.scoredGoals = scoredGoals;
    }

    @Column(name = "player_assists")
    public Integer getPlayerAssists() {
        return playerAssists;
    }

    public void setPlayerAssists(Integer playerAssists) {
        this.playerAssists = playerAssists;
    }

    @Column(name = "played_minutes")
    public Integer getPlayedMinutes() {
        return playedMinutes;
    }

    public void setPlayedMinutes(Integer playedMinutes) {
        this.playedMinutes = playedMinutes;
    }
}
