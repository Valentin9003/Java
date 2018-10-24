package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "FN")
public class FreshNuke extends BasicShampoo {

    public FreshNuke() {
    }
}
