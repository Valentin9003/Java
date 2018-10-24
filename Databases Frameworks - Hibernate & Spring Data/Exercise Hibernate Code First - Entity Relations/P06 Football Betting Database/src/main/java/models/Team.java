package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team {

    private Long id;
    private String name;
    private byte[] logo;
    private String letterInitials;
    private Color primaryKitColor;
    private Color secondaryKitColor;
    private Town town;
    private Double budget;
    private Set<Player> players;

    public Team() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Lob
    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    @Column(name = "letter_Initials")
    public String getLetterInitials() {
        return letterInitials;
    }

    public void setLetterInitials(String letterInitials) {
        this.letterInitials = letterInitials;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "primary_color_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_team_primary_color"))
    public Color getPrimaryKitColor() {
        return primaryKitColor;
    }

    public void setPrimaryKitColor(Color primaryKitColor) {
        this.primaryKitColor = primaryKitColor;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "secondary_color_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_team_secondary_color"))
    public Color getSecondaryKitColor() {
        return secondaryKitColor;
    }

    public void setSecondaryKitColor(Color secondaryKitColor) {
        this.secondaryKitColor = secondaryKitColor;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "town_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_team_town"))
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    @Column(name = "budget")
    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
