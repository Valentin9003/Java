package org.softuni.mostwanted.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "districts")
public class District {

    private Integer id;
    private String name;
    private Town town;
    private List<Race> races;

    public District() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    @OneToMany(mappedBy = "district")
    public List<Race> getRaces() {
        return races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }
}
