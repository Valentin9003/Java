package model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "mint")
@PrimaryKeyJoinColumn(name = "id")
public class Mint extends BasicIngredient {

    private static final String DEFAULT_NAME = "Mint";
    private static final BigDecimal DEFAULT_PRICE = BigDecimal.valueOf(0.34);

    public Mint() {
        super(DEFAULT_NAME, DEFAULT_PRICE);
    }
}
