package com.company.problem06Animals.models;

public abstract class Animal {

    private String type;
    private String name;
    private int age;
    private String gender;

    public Animal(String type, String name, int age, String gender) {
        this.setType(type);
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    protected String getType() {
        return type;
    }

    private void setType(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.type = type;
    }

    protected String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    protected int getAge() {
        return age;
    }

    private void setAge(int age) {
        if (age < 1) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    protected String getGender() {
        return gender;
    }

    private void setGender(String gender) {
        if (gender == null || gender.isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    public String produceSound() {
        return String.format("Not implemented!");
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %s%n" +
                        "%s",
                this.getType(),
                this.getName(),
                this.getAge(),
                this.getGender(),
                this.produceSound());
    }
}
