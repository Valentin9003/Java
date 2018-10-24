import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();

        String[] setsLength = reader.readLine().split(" ");

        fillDataInSets(reader, firstSet, secondSet, setsLength);

        System.out.println(getStringResult(firstSet, secondSet));
    }

    private static String getStringResult(Set<String> firstSet, Set<String> secondSet) {
        StringBuilder result = new StringBuilder();
        for (String element : firstSet) {
            if (secondSet.contains(element)) {
                result.append(element).append(" ");
            }
        }
        return result.toString().trim();
    }

    private static void fillDataInSets(BufferedReader reader, Set<String> firstSet, Set<String> secondSet, String[] setsLength) throws IOException {
        int lines = Integer.parseInt(setsLength[0]) + Integer.parseInt(setsLength[1]);
        for (int i = 1; i <= lines; i++) {
            if (i <= Integer.parseInt(setsLength[0])) {
                String token = reader.readLine();
                firstSet.add(token);
            } else {
                String token = reader.readLine();
                secondSet.add(token);
            }
        }
    }
}
