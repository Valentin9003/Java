package p06_strategyPattern;

import p06_strategyPattern.comparators.ComparatorByAge;
import p06_strategyPattern.comparators.ComparatorByNameLength;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> firstSet = new TreeSet<>(new ComparatorByNameLength());
        Set<Person> secondSet = new TreeSet<>(new ComparatorByAge());

        int numberOfPersons = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfPersons; i++) {
            String[] personTokens = reader.readLine().split("\\s+");
            String name = personTokens[0];
            int age = Integer.parseInt(personTokens[1]);
            Person person = new Person(name, age);

            firstSet.add(person);
            secondSet.add(person);
        }

        firstSet.forEach(System.out::println);
        secondSet.forEach(System.out::println);
    }
}
