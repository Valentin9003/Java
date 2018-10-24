package com.company.problem7CompanyHierarchy.models;

import com.company.problem7CompanyHierarchy.interfaces.IPerson;

public abstract class Person implements IPerson {

    private String id;
    private String firstName;
    private String lastName;

    public Person(String id, String firstName, String lastName) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        if (id == null || id.length() != 10) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().length() < 3) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        if (lastName == null || lastName.trim().length() < 3) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
