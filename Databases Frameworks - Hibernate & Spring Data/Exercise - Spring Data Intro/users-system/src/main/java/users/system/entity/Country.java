package users.system.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "coutries")
public class Country {

    private Long id;
    private String name;
    private Set<Town> townSet;

    public Country() {
        this.townSet = new HashSet<>();
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

    @OneToMany(mappedBy = "country")
    public Set<Town> getTownSet() {
        return townSet;
    }

    public void setTownSet(Set<Town> townSet) {
        this.townSet = townSet;
    }
}
