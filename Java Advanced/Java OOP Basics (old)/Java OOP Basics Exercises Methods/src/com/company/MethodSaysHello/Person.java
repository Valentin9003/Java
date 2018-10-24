package com.company.MethodSaysHello;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println(String.format("%s says Hello!", this.name));
    }
}
