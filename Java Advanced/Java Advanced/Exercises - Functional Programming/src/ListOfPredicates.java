import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nRange = Integer.parseInt(reader.readLine());

        Set<Integer> numsSequence =
                Arrays.stream(reader.readLine()
                        .split("\\s+"))
                        .map(Integer::valueOf)
                        .collect(Collectors.toSet());

        BiPredicate<Set<Integer>, Integer> predicate = (nums, integer) -> {
            for (Integer num : nums) {
                if (integer % num != 0)
                    return false;
            }
            return true;
        };

        for (int i = 1; i <= nRange; i++) {
            if (predicate.test(numsSequence, i))
                System.out.print(i + " ");
        }
    }
}
