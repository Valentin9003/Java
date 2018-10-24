package com.company.problem06Animals.models;

public class Dog extends Animal {

    public Dog(String type, String name, int age, String gender) {
        super(type, name, age, gender);
    }

    @Override
    public String produceSound() {
        return String.format("BauBau");
    }
}
