package com.company.OldestFamilyMember;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());
        Family family = new Family();

        for (int i = 0; i < n; i++) {
            String[] inputArr = reader.readLine().split("\\s+");
            String name = inputArr[0];
            Integer age = Integer.valueOf(inputArr[1]);

            Person person = new Person(name, age);
            family.addFamilyMember(person);
        }

        System.out.println(String.format("%s %d",
                family.getOldestMember().getName(),
                family.getOldestMember().getAge()));

        Method getOldestMethod = Family.class.getMethod("getOldestMember");
        Method addMemberMethod =Family.class.getMethod("addFamilyMember",Person.class);

    }
}
