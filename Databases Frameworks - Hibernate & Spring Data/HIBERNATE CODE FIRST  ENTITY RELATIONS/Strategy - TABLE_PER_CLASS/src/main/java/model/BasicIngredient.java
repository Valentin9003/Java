package model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
//Име на таблицата
@Table(name = "ingredients")
//Стратегия за създаване на таблица във DB - за всeки клас си има таблица
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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
    //За TABLE_PER_CLASS стратегия задаваме GenerationType да е TABLE (за Auto_Increment на id-то)
    //Създава си допълнителна таблица hibernate_sequences, където се пази стойността за следващото id.
    //Генератор за id-та, работи за всичките таблици едновремено.
    @GeneratedValue(strategy = GenerationType.TABLE)
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
