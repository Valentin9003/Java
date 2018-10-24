package models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("Credit Card")
@Table(name = "credit_cards")
public class CreditCard extends BasicBillingDetail {

    private String cardType;
    private String expirationMonth;
    private String expirationYear;

    public CreditCard() {
    }

    @Column(name = "card_type")
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Column(name = "expiration_month")
    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    @Column(name = "expiration_year")
    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }
}
