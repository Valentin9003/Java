import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroupByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> peopleDB = new ArrayList<>();

        readFromConsoleAndFillPeopleDB(reader, peopleDB);

        peopleDB.stream()
                .collect(Collectors.groupingBy(Person::getGroup))
                .forEach((key, value) ->
                        System.out.println(String.format("%d - %s",
                                key,
                                value.stream()
                                .map(Person::getName)
                                .collect(Collectors.joining(", "))
                )));
    }

    private static void readFromConsoleAndFillPeopleDB(BufferedReader reader, List<Person> peopleDB) throws IOException {
        String line;
        while (!"END".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");
            String fullName = tokens[0] + " " + tokens[1];
            int group = Integer.parseInt(tokens[2]);

            Person person = new Person(fullName, group);
            peopleDB.add(person);
        }
    }
}

class Person {
    private String name;
    private Integer group;

    public Person(String name, Integer group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public Integer getGroup() {
        return group;
    }
}
