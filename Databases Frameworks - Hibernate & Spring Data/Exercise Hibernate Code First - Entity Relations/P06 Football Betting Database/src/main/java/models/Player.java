package models;

import javax.persistence.*;

@Entity
@Table(name = "players")
public class Player {

    private Long id;
    private String name;
    private Integer squadNumber;
    private Team team;
    private Position position;
    private boolean isCurrentlyInjured;

    public Player() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "squad_number")
    public Integer getSquadNumber() {
        return squadNumber;
    }

    public void setSquadNumber(Integer squadNumber) {
        this.squadNumber = squadNumber;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_player_team"))
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_player_position"))
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Column(name = "is_currently_injured")
    public boolean isCurrentlyInjured() {
        return isCurrentlyInjured;
    }

    public void setCurrentlyInjured(boolean currentlyInjured) {
        isCurrentlyInjured = currentlyInjured;
    }
}
