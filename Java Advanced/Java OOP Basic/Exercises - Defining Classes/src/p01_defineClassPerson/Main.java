package p01_defineClassPerson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class person = Person.class;
        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);
    }
}
