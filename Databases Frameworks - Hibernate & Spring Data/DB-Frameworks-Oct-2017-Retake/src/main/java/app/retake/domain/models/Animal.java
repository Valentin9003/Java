package app.retake.domain.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "animals")
public class Animal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20)
    private String name;

    @Column(length = 20)
    private String type;

    private Integer age;

    @OneToOne(cascade = CascadeType.ALL)
    private Passport passport;

    @OneToMany(mappedBy = "animal")
    private Set<Procedure> procedures;

    public Animal() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Set<Procedure> getProcedures() {
        return procedures;
    }

    public void setProcedures(Set<Procedure> procedures) {
        this.procedures = procedures;
    }

    @PrePersist
    private void setRelation() {
        this.passport.setAnimal(this);
    }
}
