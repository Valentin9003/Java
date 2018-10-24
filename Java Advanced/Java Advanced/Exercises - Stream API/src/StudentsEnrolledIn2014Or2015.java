import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class StudentsEnrolledIn2014Or2015 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Pair<String, String>> studList = new LinkedList<>();

        String line;
        while (!"END".equals(line = reader.readLine())) {
            String facultyNumber = line.split("\\s+")[0];
            String marks = line.replaceFirst(facultyNumber, "").trim();

            studList.add(new Pair<>(facultyNumber, marks));
        }

        studList.stream()
                .filter(s -> s.getKey().endsWith("14") || s.getKey().endsWith("15"))
                .forEach(s -> System.out.println(s.getValue()));
    }
}
