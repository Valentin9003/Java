package models;

import models.Interfaces.IPerson;

import javax.persistence.*;

@Entity
@Table(name = "persons")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "status", discriminatorType = DiscriminatorType.STRING)
public abstract class Person implements IPerson {

    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Person() {
    }

    public Person(String firstName, String lastName, String phoneNumber) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPhoneNumber(phoneNumber);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false, length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false, length = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "phone_number", length = 30)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
