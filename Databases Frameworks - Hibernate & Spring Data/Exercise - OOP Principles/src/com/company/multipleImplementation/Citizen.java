package com.company.multipleImplementation;

public class Citizen implements Person, Identifiable, Birthable {

    private String name;
    private Integer age;
    private String id;
    private String birthdate;

    public Citizen(String name, Integer age, String id, String birthdate) {
        this.setName(name);
        this.setAge(age);
        this.setId(id);
        this.setBirthdate(birthdate);
    }

    public Citizen(String name, Integer age) {
        this.setName(name);
        this.setAge(age);
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String getBirthdate() {
        return birthdate;
    }

    private void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    private void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }
}
