package com.company.Problem5AnimalClinic;

public class Animal {
    private String name;
    private String breed;
    private String command;

    public Animal(String name, String breed, String command) {
        this.setName(name);
        this.setBreed(breed);
        this.setCommand(command);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException("Animal name cannot be null!");
        }
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    private void setBreed(String breed) {
        if (breed.length() < 1) {
            throw new IllegalArgumentException("Animal breed cannot be null!");
        }
        this.breed = breed;
    }

    public String getCommand() {
        return command;
    }

    private void setCommand(String command) {
        this.command = command;
    }
}
