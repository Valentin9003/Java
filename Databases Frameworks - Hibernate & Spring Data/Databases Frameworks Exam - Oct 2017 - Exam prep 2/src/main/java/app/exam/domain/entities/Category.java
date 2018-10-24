package app.exam.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 3, max = 30)
    @Column(length = 30, nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Item> items;

    public Category() {
        this.items = new ArrayList<>();
    }

    public Category(String name) {
        this.items = new ArrayList<>();
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
