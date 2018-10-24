package bookshopsystem.dto;

import bookshopsystem.enums.AgeRestriction;
import bookshopsystem.enums.EditionType;

import java.math.BigDecimal;

public interface ReducedBook {

    public String getTitle();

    public void setTitle(String title);

    public EditionType getEditionType();

    public void setEditionType(EditionType editionType);

    public AgeRestriction getAgeRestriction();

    public void setAgeRestriction(AgeRestriction ageRestriction);

    public BigDecimal getPrice();

    public void setPrice(BigDecimal price);
}
