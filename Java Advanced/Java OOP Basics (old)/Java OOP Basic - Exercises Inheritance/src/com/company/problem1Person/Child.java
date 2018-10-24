package com.company.problem1Person;

public class Child extends Person {

    public Child(String name, int age) {
        super(name, age);
    }

    @Override
    protected void setAge(int age) {
        if (age > 15) {
            throw new IllegalArgumentException("Child’s age must be less than 15!");
        }
        super.setAge(age);
    }
}
