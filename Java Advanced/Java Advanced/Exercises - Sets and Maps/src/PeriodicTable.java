import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> elements = new TreeSet<>();

        int linesCount = Integer.valueOf(reader.readLine());
        for (int i = 0; i < linesCount; i++) {
            String[] tokens = reader.readLine().split(" ");
            elements.addAll(Arrays.asList(tokens));
        }

        elements.forEach(e -> System.out.print(e + " "));
    }
}
