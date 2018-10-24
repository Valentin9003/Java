import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class FilterStudentsByEmailDomain {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Pair<String, String>> studList = new LinkedList<>();

        String line;
        while (!"END".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");
            String fullName = tokens[0] + " " + tokens[1];
            String email = tokens[2];

            studList.add(new Pair<>(fullName, email));
        }

        studList.stream()
                .filter(s -> s.getValue().endsWith("@gmail.com"))
                .forEach(s ->
                        System.out.println(String.format("%s", s.getKey())));
    }
}
