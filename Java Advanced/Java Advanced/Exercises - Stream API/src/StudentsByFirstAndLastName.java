
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> studentsDB = new LinkedList<>();

        String line;
        while (!"END".equals(line = reader.readLine())) {
            studentsDB.add(line);
        }

        studentsDB.stream()
                .filter(s -> s.split(" ")[0].compareTo(s.split(" ")[1]) < 0)
                .forEach(System.out::println);
    }
}
