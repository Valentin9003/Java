package model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "MT")
public class Mint extends BasicIngredient {

    private static final String DEFAULT_NAME = "Mint";
    private static final BigDecimal DEFAULT_PRICE = BigDecimal.valueOf(0.34);

    public Mint() {
        super(DEFAULT_NAME, DEFAULT_PRICE);
    }
}
