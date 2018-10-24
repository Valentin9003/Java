package org.softuni.mostwanted.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "race_entries")
public class RaceEntry {

    private Integer id;
    private Boolean hasFinished;
    private Double finishTime;
    private Car car;
    private Racer racer;
    private Race race;

    public RaceEntry() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getHasFinished() {
        return hasFinished;
    }

    public void setHasFinished(Boolean hasFinished) {
        this.hasFinished = hasFinished;
    }

    public Double getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Double finishTime) {
        this.finishTime = finishTime;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Racer getRacer() {
        return racer;
    }

    public void setRacer(Racer racer) {
        this.racer = racer;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}
