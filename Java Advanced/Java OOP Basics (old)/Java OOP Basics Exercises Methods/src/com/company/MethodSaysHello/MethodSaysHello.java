package com.company.MethodSaysHello;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MethodSaysHello {
    public static void main(String[] args) {
        Person person = new Person("Ivelin");
        person.sayHello();

        Field[] fields = Person.class.getDeclaredFields();
        Method[] methods = Person.class.getDeclaredMethods();
        if (fields.length != 1 || methods.length != 1) {
            throw new ClassFormatError();
        }

    }
}
