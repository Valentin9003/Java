package com.company.defineAnInterfacPerson;

public class Citizen implements Person {

    private String name;
    private Integer age;

    public Citizen(String name, Integer age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    private void setAge(Integer age) {
        this.age = age;
    }
}
