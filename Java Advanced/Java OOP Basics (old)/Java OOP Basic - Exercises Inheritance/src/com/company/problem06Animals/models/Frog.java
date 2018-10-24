package com.company.problem06Animals.models;

public class Frog extends Animal {

    public Frog(String type, String name, int age, String gender) {
        super(type, name, age, gender);
    }

    @Override
    public String produceSound() {
        return String.format("Frogggg");
    }
}
