package model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
//Име на таблицата
@Table(name = "ingredients")
//Стратегия за създаване на една таблица във DB за всички класове
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//Kолона чрез която разпознава разлилните класове. discriminatorType не е задължителен
@DiscriminatorColumn(name = "ingredient_type", discriminatorType = DiscriminatorType.STRING)
public abstract class BasicIngredient implements Ingredient {

    private Long id;
    private String name;
    private BigDecimal price;

    public BasicIngredient() {
    }

    public BasicIngredient(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    //Анотираме че тази колона във таблицата ще е Id
    @Id
    //За SINGLE_TABLE стратегия задаваме GenerationType да е IDENTITY (за Auto_Increment на id-то)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
