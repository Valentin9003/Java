import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WeakStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Integer>> studentsMap = new LinkedHashMap<>();

        String line;
        while (!"END".equals(line = reader.readLine())) {
            String fullName = line.split("\\s+")[0] + " " + line.split("\\s+")[1];
            List<Integer> marks =
                    Arrays.stream(line.split("\\s+"))
                            .skip(2)
                            .map(Integer::valueOf)
                            .collect(Collectors.toList());

            studentsMap.putIfAbsent(fullName, marks);
        }

        studentsMap.entrySet().stream()
                .filter(s -> s.getValue().stream().filter(mark -> mark <= 3).count() >= 2)
                .forEach(s -> System.out.println(s.getKey()));
    }
}
