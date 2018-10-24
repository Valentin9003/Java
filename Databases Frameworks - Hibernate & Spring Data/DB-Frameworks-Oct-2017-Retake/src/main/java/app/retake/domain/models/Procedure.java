package app.retake.domain.models;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "procedures")
public class Procedure implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JoinTable(name = "animal_aids_procedures")
    private Set<AnimalAid> services;

    @ManyToOne
    private Animal animal;

    @ManyToOne
    private Vet vet;

    @Column(name = "date_performed")
    private Date date;

    public Procedure() {
        this.services = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<AnimalAid> getServices() {
        return services;
    }

    public void setServices(Set<AnimalAid> services) {
        this.services = services;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getCost() {
        BigDecimal cost = BigDecimal.ZERO;
        for (AnimalAid animalAid : this.getServices()) {
            cost = cost.add(animalAid.getPrice());
        }
        return cost;
    }
}
