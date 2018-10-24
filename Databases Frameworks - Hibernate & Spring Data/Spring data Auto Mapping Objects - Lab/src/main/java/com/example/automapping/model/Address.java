package com.example.automapping.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address {

    private Long id;
    private String street;
    private City city;
    private Set<Employee> employees;

    public Address() {
        employees = new HashSet<>();
    }

    public Address(String street, City city) {
        this.street = street;
        this.city = city;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @OneToMany(mappedBy = "address")
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = City.class)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
