import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class SortStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Pair<String, String>> studentsDB = new LinkedList<>();

        String line;
        while (!"END".equals(line = reader.readLine())) {
            String firstName = line.split("\\s+")[0];
            String lastName = line.split("\\s+")[1];

            studentsDB.add(new Pair<>(firstName, lastName));
        }

        studentsDB.stream()
                .sorted((s1,s2) -> {
                    if (s1.getValue().compareTo(s2.getValue()) != 0) {
                        return s1.getValue().compareTo(s2.getValue());
                    } else {
                        return s2.getKey().compareTo(s1.getKey());
                    }
                })
                .forEach(s ->
                        System.out.println(String.format("%s %s", s.getKey(), s.getValue())));
    }
}
