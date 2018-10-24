package p04_froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine()
                .split("[,\\s]+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Lake lake = new Lake(numbers);

        String endLine = reader.readLine();

        StringBuilder result = new StringBuilder();
        for (Integer number : lake) {
            result.append(number).append(", ");
        }

        result.delete(result.length() - 2, result.length());
        System.out.println(result);
    }
}
