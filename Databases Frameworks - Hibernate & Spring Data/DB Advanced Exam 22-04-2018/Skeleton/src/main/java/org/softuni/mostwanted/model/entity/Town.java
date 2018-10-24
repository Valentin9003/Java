package org.softuni.mostwanted.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "towns")
public class Town {

    private Integer id;
    private String name;
    private List<Racer> racers;
    private List<District> districts;

    public Town() {
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

    @OneToMany(mappedBy = "homeTown")
    public List<Racer> getRacers() {
        return racers;
    }

    public void setRacers(List<Racer> racers) {
        this.racers = racers;
    }

    @OneToMany(mappedBy = "town")
    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }
}
