package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "coutries")
public class Country {

    private String id;
    private String name;
    private Continent continent;
    private Set<Town> towns;

    public Country() {
    }

    @Id
    @Column(length = 3)
    public String getId() {
        return id;
    }

    public void setId(String id) {
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
    @JoinColumn(name = "continent_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_coutry_continent"))
    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continet) {
        this.continent = continet;
    }

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    public Set<Town> getTowns() {
        return towns;
    }

    public void setTowns(Set<Town> towns) {
        this.towns = towns;
    }
}
