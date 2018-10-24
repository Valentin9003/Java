package model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "production_batch")
public class ProductionBatch {

    private Long id;
    private Set<BasicShampoo> basicShampoos;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "productionBatch", targetEntity = BasicShampoo.class, fetch = FetchType.EAGER)
    public Set<BasicShampoo> getBasicShampoos() {
        return basicShampoos;
    }

    public void setBasicShampoos(Set<BasicShampoo> basicShampoos) {
        this.basicShampoos = basicShampoos;
    }

    @Override
    public String toString() {
        return "ProductionBatch{" +
                "id=" + id +
                ", basicShampoos=" + basicShampoos +
                '}';
    }
}
