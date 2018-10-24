package com.company.problem03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class OpinionPoll {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, Person> personsMap = new TreeMap<>();
        int numberPersons = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberPersons; i++) {
            String[] input = reader.readLine().split(" ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            Person person = new Person(name, age);
            personsMap.put(name, person);
        }

        for (String personName : personsMap.keySet()) {
            if (personsMap.get(personName).getAge() > 30) {
                System.out.printf("%s - %d%n", personsMap.get(personName).getName(), personsMap.get(personName).getAge());
            }
        }
    }
}
