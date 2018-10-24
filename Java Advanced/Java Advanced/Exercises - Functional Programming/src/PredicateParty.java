import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> people =
                Arrays.stream(reader.readLine()
                        .split("\\s+"))
                        .collect(Collectors.toList());

        Predicate<String> loopStoper = "Party!"::equals;

        String tokens;
        while (loopStoper.negate().test(tokens = reader.readLine())) {
            executeCommand(people, tokens);
        }

        if (people.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.print(
                    String.format("%s are going to the party!",
                            String.join(", ", people)));
        }
    }

    private static void executeCommand(List<String> people, String tokens) {
        List<String> resultList = new ArrayList<>();
        String command = tokens.split("\\s+")[0];
        String option = tokens.split("\\s+")[1];
        String criteria = tokens.split("\\s+")[2];

        Predicate<String> doublePersons = "Double"::equals;

        BiPredicate<String, Integer> lengthComparing = (n1, length) -> n1.length() == length;
        BiPredicate<String, String> startWithComparing = (name, str) -> name.startsWith(str);
        BiPredicate<String, String> endWithComparing = (name, str) -> name.endsWith(str);

        if (doublePersons.test(command)) {
            //if command is Double
            doubleThePersons(people,
                    resultList,
                    option,
                    criteria,
                    lengthComparing,
                    startWithComparing,
                    endWithComparing);
        } else {
            //if command is Remove
            removeThePersons(people,
                    resultList,
                    option,
                    criteria,
                    lengthComparing,
                    startWithComparing,
                    endWithComparing);
        }

        people.clear();
        people.addAll(resultList);
    }

    private static void removeThePersons(List<String> people, List<String> resultList, String option, String criteria, BiPredicate<String, Integer> lengthComparing, BiPredicate<String, String> startWithComparing, BiPredicate<String, String> endWithComparing) {
        switch (option) {
            case "StartsWith":
                removeWhenStartWith(resultList, people, startWithComparing, criteria);
                break;
            case "EndsWith":
                removeWhenEndsWith(resultList, people, endWithComparing, criteria);
                break;
            case "Length":
                removeWhenLengthIsEqual(resultList, people, lengthComparing, criteria);
                break;
        }
    }

    private static void doubleThePersons(List<String> people, List<String> resultList, String option, String criteria, BiPredicate<String, Integer> lengthComparing, BiPredicate<String, String> startWithComparing, BiPredicate<String, String> endWithComparing) {
        switch (option) {
            case "StartsWith":
                doubleWhenStartWith(resultList, people, startWithComparing, criteria);
                break;
            case "EndsWith":
                doubleWhenEndsWith(resultList, people, endWithComparing, criteria);
                break;
            case "Length":
                doubleWhenLengthIsEqual(resultList, people, lengthComparing, criteria);
                break;
        }
    }

    private static void removeWhenLengthIsEqual(List<String> resultList, List<String> people, BiPredicate<String, Integer> lengthComparing, String criteria) {
        for (String person : people) {
            if (lengthComparing.test(person, Integer.parseInt(criteria)))
                continue;
            resultList.add(person);
        }
    }

    private static void removeWhenEndsWith(List<String> resultList, List<String> people, BiPredicate<String, String> endWithComparing, String criteria) {
        for (String person : people) {
            if (endWithComparing.test(person, criteria))
                continue;
            resultList.add(person);
        }
    }

    private static void removeWhenStartWith(List<String> resultList, List<String> people, BiPredicate<String, String> startWithComparing, String criteria) {
        for (String person : people) {
            if (startWithComparing.test(person, criteria))
                continue;
            resultList.add(person);
        }
    }

    private static void doubleWhenLengthIsEqual(List<String> resultList, List<String> people, BiPredicate<String, Integer> lengthComparing, String criteria) {
        for (String person : people) {
            resultList.add(person);
            if (lengthComparing.test(person, Integer.parseInt(criteria)))
                resultList.add(person);
        }
    }

    private static void doubleWhenEndsWith(List<String> resultList, List<String> people, BiPredicate<String, String> endWithComparing, String criteria) {
        for (String person : people) {
            resultList.add(person);
            if (endWithComparing.test(person, criteria))
                resultList.add(person);
        }
    }

    private static void doubleWhenStartWith(List<String> resultList, List<String> people, BiPredicate<String, String> startWithComparing, String criteria) {
        for (String person : people) {
            resultList.add(person);
            if (startWithComparing.test(person, criteria))
                resultList.add(person);
        }
    }
}
