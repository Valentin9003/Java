package com.company.borderControl;

public class Citizen extends Society {

    private String name;
    private Integer age;

    public Citizen(String name, Integer age, String id) {
        super(id);
        this.setName(name);
        this.setAge(age);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
