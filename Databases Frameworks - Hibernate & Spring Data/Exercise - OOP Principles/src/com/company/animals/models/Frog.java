package com.company.animals.models;

public class Frog extends Animals {

    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void produceSound() {
        System.out.println("Frogggg");
    }

    @Override
    public String toString() {
        return String.format("Frog%n%s %d %s", this.getName(), this.getAge(), this.getGender());
    }
}
