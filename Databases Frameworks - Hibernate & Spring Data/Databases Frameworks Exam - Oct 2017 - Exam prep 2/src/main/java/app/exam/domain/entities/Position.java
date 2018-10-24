package app.exam.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "positions")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 3, max = 30)
    @Column(length = 30, nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
    private Set<Employee> employees;

    public Position() {
        this.employees = new HashSet<>();
    }

    public Position(String name) {
        this.employees = new HashSet<>();
        this.name = name;
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

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
