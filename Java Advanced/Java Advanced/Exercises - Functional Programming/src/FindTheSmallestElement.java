import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> smallestNumIndex = arr -> {
            int index = 0;
            int bufferNum = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] <= bufferNum) {
                    bufferNum = arr[i];
                    index = i;
                }
            }
            return index;
        };

        System.out.println(smallestNumIndex.apply(numbers));
    }
}
