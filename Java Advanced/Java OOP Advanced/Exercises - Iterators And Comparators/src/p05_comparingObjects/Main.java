package p05_comparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> personDB = new ArrayList<>();
        String line;
        while (!"END".equalsIgnoreCase(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];
            personDB.add(new Person(name, age, town));
        }

        int index = Integer.parseInt(reader.readLine());
        Person person = personDB.get(index - 1);

        long equalCount =
                personDB.stream()
                .filter(p -> p.compareTo(person) == 0)
                .count();

        if (equalCount == 1) {
            System.out.println("No matches");
        } else {
            System.out.println(String.format("%d %d %d",
                    equalCount,
                    personDB.size() - equalCount,
                    personDB.size()));
        }
    }
}
