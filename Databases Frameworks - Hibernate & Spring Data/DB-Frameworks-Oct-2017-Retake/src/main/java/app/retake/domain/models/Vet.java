package app.retake.domain.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 40)
    private String name;

    @Column(length = 50)
    private String profession;

    private Integer age;

    private String phoneNumber;

    @OneToMany(mappedBy = "vet")
    private Set<Procedure> procedures;

    public Vet() {
        this.procedures = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Procedure> getProcedures() {
        return procedures;
    }

    public void setProcedures(Set<Procedure> procedures) {
        this.procedures = procedures;
    }
}
