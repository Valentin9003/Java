import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int givenSize = Integer.parseInt(reader.readLine());
        String[] names = reader.readLine().split("\\s+");

        BiPredicate<String, Integer> checkNameLength = (name, size) -> name.length() <= size;

        BiConsumer<String[], Integer> printIfPassed = (arr, size) -> {
            Arrays.stream(arr).forEach(nameStr -> {
                if (checkNameLength.test(nameStr, size))
                    System.out.println(nameStr);
            });
        };

        printIfPassed.accept(names, givenSize);
    }
}
