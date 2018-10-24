import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiFunction;

public class AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        BiFunction<Integer, String, Integer> func = (num, cmnd) -> {
            int result = 0;
            switch (cmnd) {
                case "add":
                    result = num + 1;
                    break;
                case "multiply":
                    result = num * 2;
                    break;
                case "subtract":
                    result = num - 1;
                    break;
            }
            return result;
        };

        String command;
        while (!"end".equals(command = reader.readLine())) {

            if ("print".equals(command)) {
                Arrays.stream(numbers).forEach(n -> System.out.print(n + " "));
                continue;
            }

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = func.apply(numbers[i], command);
            }
        }
    }
}
