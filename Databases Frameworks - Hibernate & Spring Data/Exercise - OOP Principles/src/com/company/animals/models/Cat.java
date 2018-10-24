package com.company.animals.models;

public class Cat extends Animals {

    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void produceSound() {
        System.out.println("MiauMiau");
    }

    @Override
    public String toString() {
        return String.format("Cat%n%s %d %s", this.getName(), this.getAge(), this.getGender());
    }
}
