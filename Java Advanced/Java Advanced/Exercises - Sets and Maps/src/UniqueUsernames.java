import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.LinkedHashSet;
        import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> uniqueUsernames = new LinkedHashSet<>();

        int nameNumber = Integer.parseInt(reader.readLine());

        for (int i = 0; i < nameNumber; i++) {
            uniqueUsernames.add(reader.readLine());
        }

        uniqueUsernames.forEach(System.out::println);
    }
}
