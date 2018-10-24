package com.company.problem02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;

class Person {
    static final String DEFFAULT_NAME = "No name";
    static final int DEFFAULT_AGE = 1;

    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Person() {
        this(DEFFAULT_NAME, DEFFAULT_AGE);
    }

    Person(String name) {
        this(name, DEFFAULT_AGE);
    }

    Person(int age) {
        this(DEFFAULT_NAME, age);
    }
}

public class Demos {
    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
        Class personClass = Person.class;
        Constructor emptyCtor = personClass.getDeclaredConstructor();
        Constructor ageCtor = personClass.getDeclaredConstructor(int.class);
        Constructor nameAgeCtor = personClass
                .getDeclaredConstructor(String.class, int.class);
        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        Person basePerson = (Person) emptyCtor.newInstance();
        Person personWithAge = (Person) ageCtor.newInstance(age);
        Person personFull = (Person) nameAgeCtor.newInstance(name, age);
        System.out.printf("%s %s%n", basePerson.name, basePerson.age);
        System.out.printf("%s %s%n", personWithAge.name, personWithAge.age);
        System.out.printf("%s %s%n", personFull.name, personFull.age);
    }
}
