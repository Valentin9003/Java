package json.processing.model.entity;

import json.processing.validation.Phone;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "phone_numbers")
public class PhoneNumber {

    private Long id;
    private String number;
    private Person person;

    public PhoneNumber() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Phone
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
