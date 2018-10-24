package com.company.animals.models;

import com.company.animals.Interfaces.Producible;

public abstract class Animals implements Producible {

    public static final String DEFAULT_MESSAGE_FOR_INVALID_INPUT = "Invalid input!";

    private String name;
    private int age;
    private String gender;

    public Animals(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(DEFAULT_MESSAGE_FOR_INVALID_INPUT);
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException(DEFAULT_MESSAGE_FOR_INVALID_INPUT);
        }
        this.age = age;
    }

    protected void setGender(String gender) {
        if (gender == null || gender.trim().isEmpty()) {
            throw new IllegalArgumentException(DEFAULT_MESSAGE_FOR_INVALID_INPUT);
        }
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void produceSound() {
        System.out.println("Not implemented!");
    }
}
