package com.company.animals.models;

public class Kitten extends Cat {

    public Kitten(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void produceSound() {
        System.out.println("Miau");
    }

    @Override
    public String toString() {
        return String.format("Kitten%n%s %d %s", this.getName(), this.getAge(), this.getGender());
    }
}
