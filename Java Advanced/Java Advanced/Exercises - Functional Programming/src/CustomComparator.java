import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        Integer[] numbers = new Integer[input.length];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        Predicate<Integer> isEven = n -> n % 2 == 0;

        Comparator<Integer> customComp = (firstNum, secondNum) -> {
            if (firstNum != secondNum) {
                if (isEven.test(firstNum) && isEven.negate().test(secondNum)) {
                    // One is even, the other one is odd
                    return -1;
                } else if (isEven.negate().test(firstNum) && isEven.test(secondNum)) {
                    // One is odd, the other one is even
                    return 1;
                } else {
                    // Both numbers are odd or both numbers are even
                    return firstNum - secondNum;
                }
            } else {
                return 0;
            }
        };

        Arrays.sort(numbers, customComp);

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
