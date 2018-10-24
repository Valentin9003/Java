package model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shampoos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class BasicShampoo {

    private Long id;
    private ClassicLabel label;
    private ProductionBatch productionBatch;
    private Set<BasicIngredient> basicIngredients;

    public BasicShampoo() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "label_id")
    public ClassicLabel getLabel() {
        return label;
    }

    public void setLabel(ClassicLabel label) {
        this.label = label;
    }

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "batch_id", referencedColumnName = "id")
    public ProductionBatch getProductionBatch() {
        return productionBatch;
    }

    public void setProductionBatch(ProductionBatch productionBatch) {
        this.productionBatch = productionBatch;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "shampoos_ingredients",
    joinColumns = @JoinColumn(name = "shampoo_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"),
    foreignKey = @ForeignKey(name = "FK_si_shampoos"),
    inverseForeignKey = @ForeignKey(name = "FK_si_ingredient"))
    public Set<BasicIngredient> getBasicIngredients() {
        return basicIngredients;
    }

    public void setBasicIngredients(Set<BasicIngredient> basicIngredients) {
        this.basicIngredients = basicIngredients;
    }

}
