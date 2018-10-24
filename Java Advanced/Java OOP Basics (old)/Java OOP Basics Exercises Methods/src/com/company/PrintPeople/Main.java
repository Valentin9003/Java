package com.company.PrintPeople;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<Person> porsonsCollection = new TreeSet<>();

        String[] inputTokens = reader.readLine().split("\\s+");
        while (!inputTokens[0].equals("END")) {
            String name = inputTokens[0];
            Integer age = Integer.valueOf(inputTokens[1]);
            String occupation = inputTokens[2];

            Person person = new Person(name, age, occupation);
            porsonsCollection.add(person);

            inputTokens = reader.readLine().split("\\s+");
        }

        for (Person person : porsonsCollection) {
            System.out.println(person);
        }
    }
}
