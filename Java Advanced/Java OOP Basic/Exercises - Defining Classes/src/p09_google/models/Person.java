package p09_google.models;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Children> childrens;
    private List<Pokemon> pokemons;

    public Person(String name) {
        this.name = name;
        this.parents = new ArrayList<>();
        this.childrens = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void addParent(Parent parent) {
        this.parents.add(parent);
    }

    public List<Children> getChildrens() {
        return childrens;
    }

    public void addChildren(Children children) {
        this.childrens.add(children);
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    @Override
    public String toString() {
        StringBuilder personBuilder = new StringBuilder();
        personBuilder.append(String.format("%s", this.getName()))
                .append(System.lineSeparator())
                .append("Company:")
                .append(System.lineSeparator());
        if (this.company != null) {
            personBuilder.append(this.getCompany()).append(System.lineSeparator());
        }
        personBuilder.append("Car:").append(System.lineSeparator());
        if (this.car != null) {
            personBuilder.append(this.getCar()).append(System.lineSeparator());
        }
        personBuilder.append("Pokemon:").append(System.lineSeparator());
        for (Pokemon pokemon : this.pokemons) {
            personBuilder.append(pokemon).append(System.lineSeparator());
        }
        personBuilder.append("Parents:").append(System.lineSeparator());
        for (Parent parent : this.parents) {
            personBuilder.append(parent).append(System.lineSeparator());
        }
        personBuilder.append("Children:").append(System.lineSeparator());
        for (Children children : this.childrens) {
            personBuilder.append(children).append(System.lineSeparator());
        }

        return personBuilder.toString();
    }
}
