package model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "amonium_cloride")
@PrimaryKeyJoinColumn(name = "id")
public class AmoniumCloride extends BasicChemicalIngredient {

    private static final String DEFAULT_FORMULA = "NH4CL";
    private static final String DEFAULT_NAME = "Amonium Cloride";
    private static final BigDecimal DEFAULT_PRICE = BigDecimal.valueOf(0.89);

    public AmoniumCloride() {
        super(DEFAULT_NAME, DEFAULT_PRICE, DEFAULT_FORMULA);
    }
}
