import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] inputArr = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> funcGetSmallestNumber = arr -> {
            return Arrays.stream(arr).min().getAsInt();
        };

        System.out.println(funcGetSmallestNumber.apply(inputArr));
    }
}
