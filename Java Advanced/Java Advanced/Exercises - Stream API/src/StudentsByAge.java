import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class StudentsByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Pair<String, Integer>> studentsDB = new LinkedList<>();

        String line;
        while (!"END".equals(line = reader.readLine())) {
            String fullName = line.split("\\s+")[0] + " " + line.split("\\s+")[1];
            int group = Integer.parseInt(line.split("\\s+")[2]);

            studentsDB.add(new Pair<>(fullName, group));
        }

        studentsDB.stream()
                .filter(s -> s.getValue() >= 18 && s.getValue() <= 24)
                .forEach(s ->
                        System.out.println(String.format("%s %d", s.getKey(), s.getValue())));
    }
}
