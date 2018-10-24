import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Long> numbers = Arrays.stream(reader.readLine().split("\\s+")).map(Long::valueOf).collect(Collectors.toList());

        String command = reader.readLine();
        while (!"end".equals(command)) {
            execute(numbers, command);
            command = reader.readLine();
        }
    }

    private static void execute(List<Long> numbers, String command) {
        Function<Long, Long> func;

        switch (command) {
            case "add":
                func = num -> num + 1;
                executeCommand(numbers, func);
                break;
            case "multiply":
                func = num -> num * 2;
                executeCommand(numbers, func);
                break;
            case "subtract":
                func = num -> num -1;
                executeCommand(numbers, func);
                break;
            case "print":
                numbers.forEach(n -> System.out.print(n + " "));
                break;
        }
    }

    private static void executeCommand(List<Long> numbers, Function<Long,Long> func) {
        for (int i = 0; i < numbers.size(); i++) {
            numbers.set(i, func.apply(numbers.get(i)));
        }
    }
}
