package com.company.birthdayCelebrations;

public class Citizens extends Societies {

    private String name;
    private Integer age;

    public Citizens(String name, Integer age, String id, String birthday) {
        super(id, birthday);
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
