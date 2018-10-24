package p04_firstAndReserveTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> persons = new ArrayList<>();

        int inputs = Integer.parseInt(reader.readLine());
        for (int i = 0; i < inputs; i++) {
            String[] personData = reader.readLine().split("\\s+");
            String firstName = personData[0];
            String lastName = personData[1];
            int age = Integer.parseInt(personData[2]);
            double salary = Double.parseDouble(personData[3]);

            try {
                persons.add(new Person(firstName, lastName, age, salary));
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }

        Team team = new Team("Minior");
        for (Person person : persons) {
            team.addPlayer(person);
        }

        System.out.println(team);
    }
}
