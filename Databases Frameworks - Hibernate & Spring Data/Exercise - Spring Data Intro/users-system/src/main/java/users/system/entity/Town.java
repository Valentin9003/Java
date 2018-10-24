package users.system.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town {

    private Long id;
    private String name;
    private Country country;
    private Set<User> usersBornHere;
    private Set<User> usersLivingHere;

    public Town() {
        this.usersBornHere = new HashSet<>();
        this.usersLivingHere = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(targetEntity = Country.class)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @OneToMany(mappedBy = "bornTown")
    public Set<User> getUsersBornHere() {
        return usersBornHere;
    }

    public void setUsersBornHere(Set<User> usersBornHere) {
        this.usersBornHere = usersBornHere;
    }

    @OneToMany(mappedBy = "currentlyLivingTown")
    public Set<User> getUsersLivingHere() {
        return usersLivingHere;
    }

    public void setUsersLivingHere(Set<User> usersLivingHere) {
        this.usersLivingHere = usersLivingHere;
    }
}
