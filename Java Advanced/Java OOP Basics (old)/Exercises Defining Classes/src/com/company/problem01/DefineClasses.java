package com.company.problem01;

import java.lang.reflect.Field;

class Person {
    String name;
    int age;
}

public class DefineClasses {
    public static void main(String[] args) throws Exception {
        Class person = Person.class;
        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);
    }
}
