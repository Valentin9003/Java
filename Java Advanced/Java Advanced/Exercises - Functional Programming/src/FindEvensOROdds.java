import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FindEvensOROdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] bounds = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String command = reader.readLine();

        executeCommand(bounds, command);
    }

    private static void executeCommand(int[] bounds, String command) {
        Predicate<Integer> predicateOddEven = num -> num % 2 == 0;

        switch (command) {
            case "odd":
                printOddNumbers(bounds, predicateOddEven);
                break;
            case "even":
                printEvenNumbers(bounds, predicateOddEven);
                break;
        }
    }

    private static void printOddNumbers(int[] bounds, Predicate<Integer> predicateOddEven) {
        int lowerBound = bounds[0];
        int upperBound = bounds[1];

        for (int i = lowerBound; i <= upperBound ; i++) {
            if (predicateOddEven.negate().test(i)) {
                printNumber(i);
            }
        }
    }

    private static void printEvenNumbers(int[] bounds, Predicate<Integer> predicateOddEven) {
        int lowerBound = bounds[0];
        int upperBound = bounds[1];

        for (int i = lowerBound; i <= upperBound ; i++) {
            if (predicateOddEven.test(i)) {
                printNumber(i);
            }
        }
    }

    private static void printNumber(int number) {
        Consumer<Integer> consumerPrint = num -> System.out.print(num + " ");
        consumerPrint.accept(number);
    }
}
