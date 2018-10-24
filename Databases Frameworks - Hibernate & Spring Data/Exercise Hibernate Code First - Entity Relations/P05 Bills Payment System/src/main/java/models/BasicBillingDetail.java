package models;

import models.interfaces.BillingDetail;

import javax.persistence.*;

@Entity
@Table(name = "billing_details")
//@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BasicBillingDetail implements BillingDetail {

    private Long id;
    private String number;
    private User owner;

    public BasicBillingDetail() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    @Column(name = "number")
    public String getNumber() {
        return this.number;
    }

    @Override
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    public User getOwner() {
        return this.owner;
    }
}
