package com.company.animals.models;

public class Dog extends Animals {

    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void produceSound() {
        System.out.println("BauBau");
    }

    @Override
    public String toString() {
        return String.format("Dog%n%s %d %s", this.getName(), this.getAge(), this.getGender());
    }
}
