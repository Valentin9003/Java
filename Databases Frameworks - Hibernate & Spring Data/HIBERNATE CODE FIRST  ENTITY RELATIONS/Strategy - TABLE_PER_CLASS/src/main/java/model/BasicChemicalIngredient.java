package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public abstract class BasicChemicalIngredient extends BasicIngredient {

    @Column(name = "chemical_formula")
    private String chemicalFormula;

    public BasicChemicalIngredient(String name, BigDecimal price, String chemicalFormula) {
        super(name, price);
        this.chemicalFormula = chemicalFormula;
    }

    public BasicChemicalIngredient() {
        this.chemicalFormula = chemicalFormula;
    }

    public String getChemicalFormula() {
        return chemicalFormula;
    }

    public void setChemicalFormula(String chemicalFormula) {
        this.chemicalFormula = chemicalFormula;
    }
}
