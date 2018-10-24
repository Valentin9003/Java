package org.softuni.mostwanted.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "racers")
public class Racer {

    private Integer id;
    private String name;
    private Integer age;
    private BigDecimal bounty;
    private Town homeTown;
    private List<Car> cars;

    public Racer() {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getBounty() {
        return bounty;
    }

    public void setBounty(BigDecimal bounty) {
        this.bounty = bounty;
    }

    @ManyToOne
    public Town getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(Town homeTown) {
        this.homeTown = homeTown;
    }

    @OneToMany(mappedBy = "racer")
    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
