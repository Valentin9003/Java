package models;

import javax.persistence.*;

@Entity
@Table(name = "competitions")
public class Competition {

    private Long id;
    private String name;
    private CompetitionType type;

    public Competition() {
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "competition_type", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_competition_type"))
    public CompetitionType getType() {
        return type;
    }

    public void setType(CompetitionType type) {
        this.type = type;
    }
}
