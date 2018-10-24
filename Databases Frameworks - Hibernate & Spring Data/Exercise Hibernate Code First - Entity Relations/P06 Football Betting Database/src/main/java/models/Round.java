package models;

import javax.persistence.*;

@Entity
@Table(name = "reounds")
public class Round {

    private Long id;
    private String name;

    public Round() {
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
}
