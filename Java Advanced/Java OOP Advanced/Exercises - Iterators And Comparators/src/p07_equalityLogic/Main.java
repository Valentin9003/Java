package p07_equalityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> personTreeSet = new TreeSet<>();
        Set<Person> personHashSet = new HashSet<>();

        int numberOfPeople = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfPeople; i++) {
            String[] personTokens = reader.readLine().split("\\s+");
            String name = personTokens[0];
            int age = Integer.parseInt(personTokens[1]);
            Person person = new Person(name, age);

            personTreeSet.add(person);
            personHashSet.add(person);
        }

        System.out.println(personTreeSet.size());
        System.out.println(personHashSet.size());
    }
}
