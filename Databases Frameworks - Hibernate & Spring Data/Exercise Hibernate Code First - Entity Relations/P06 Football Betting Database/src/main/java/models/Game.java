package models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "games")
public class Game {

    private Long id;
    private Team homeTeam;
    private Team awayTeam;
    private Integer homeTeamGoals;
    private Integer awayTeamGoals;
    private LocalDateTime dateAndTime;
    private Double homeTeamWinBetRate;
    private Double awayTeamWinBetRate;
    private Double drawGameBetRate;
    private Round round;
    private Competition competition;

    public Game() {
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
    @JoinColumn(name = "home_team", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_game_home_team"))
    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "away_team", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_game_away_team"))
    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    @Column(name = "home_team_goals")
    public Integer getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(Integer homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    @Column(name = "away_team_goals")
    public Integer getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public void setAwayTeamGoals(Integer awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
    }

    @Column(name = "date_time")
    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    @Column(name = "home_team_win_bet_rate")
    public Double getHomeTeamWinBetRate() {
        return homeTeamWinBetRate;
    }

    public void setHomeTeamWinBetRate(Double homeTeamWinBetRate) {
        this.homeTeamWinBetRate = homeTeamWinBetRate;
    }

    @Column(name = "away_team_win_bet_rate")
    public Double getAwayTeamWinBetRate() {
        return awayTeamWinBetRate;
    }

    public void setAwayTeamWinBetRate(Double awayTeamWinBetRate) {
        this.awayTeamWinBetRate = awayTeamWinBetRate;
    }

    @Column(name = "draw_game_bet_rate")
    public Double getDrawGameBetRate() {
        return drawGameBetRate;
    }

    public void setDrawGameBetRate(Double drawGameBetRate) {
        this.drawGameBetRate = drawGameBetRate;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "round_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_game_round"))
    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "competition_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_game_competition"))
    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}
