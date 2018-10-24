import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
        int givenInteger = Integer.parseInt(reader.readLine());

        BiPredicate<Integer, Integer> isDivisible = (a, b) -> a % b == 0;

        Function<List<Integer>, List<Integer>> reverseList = (nums) -> {
            Collections.reverse(nums);
            return nums;
        };

        BiConsumer<List<Integer>, Integer> removeElement = (nums, num) -> nums.remove(num);

        //reverses a collection
        numbers = reverseList.apply(numbers);

        //removes elements that are divisible by a given integer n
        List<Integer> bufferList = new ArrayList<>(numbers);
        for (Integer integer : bufferList) {
            if (isDivisible.test(integer, givenInteger))
                removeElement.accept(numbers, integer);
        }

        //print result
        numbers.forEach(n -> System.out.print(n + " "));
    }
}
