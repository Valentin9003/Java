package p02_salaryIncrease;

import p02_salaryIncrease.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();

        int inputsAmount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < inputsAmount; i++) {
            String[] personData = reader.readLine().split("\\s+");
            String firstName = personData[0];
            String lastName = personData[1];
            int age = Integer.parseInt(personData[2]);
            double salary = Double.parseDouble(personData[3]);

            people.add(new Person(firstName, lastName, age, salary));
        }

        double bonus = Double.parseDouble(reader.readLine());
        for (Person person : people) {
            person.increaseSalary(bonus);
            System.out.println(person.toString());
        }
    }
}
