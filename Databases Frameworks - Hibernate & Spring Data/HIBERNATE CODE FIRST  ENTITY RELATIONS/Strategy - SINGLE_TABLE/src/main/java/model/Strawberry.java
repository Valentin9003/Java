package model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "STRAWS")
public class Strawberry extends BasicIngredient {

    private static final String DEFAULT_NAME = "Strawberry";
    private static final BigDecimal DEFAULT_PRICE = BigDecimal.valueOf(0.22);

    public Strawberry() {
        super(DEFAULT_NAME, DEFAULT_PRICE);
    }

}
