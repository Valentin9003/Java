import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// 100/100 in judge
public class DHARMAsupplies {
    private static final String END_COMMAND = "Collect";
    private static final String NO_SUPPLIES_FOUND = "No supplies found!";
    private static final String NUMBER_OF_SUPPLY_CRATES = "Number of supply crates: %d%n";
    private static final String AMOUNT_OF_FOOD_COLLECTED = "Amount of food collected: %d%n";
    private static final String AMOUNT_OF_DRINKS_COLLECTED = "Amount of drinks collected: %d%n";

    private static final Pattern CRATE_PATTERN = Pattern.compile("\\[.*?]");
    private static final Pattern FOOD_PATTERN = Pattern.compile("\\[#(?<tag>\\d+)(?<supply>[a-zA-Z0-9\\s]+)#(\\1)]");
    private static final Pattern DRINKS_PATTERN = Pattern.compile("\\[#(?<tag>[a-z]+)(?<supply>[a-zA-Z0-9\\s]+)#(\\1)]");
    private static final String SUPPLY = "supply";
    private static final String TAG = "tag";

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int crates = 0;
        List<String> lines = new ArrayList<>();

        while (true) {
            String input = reader.readLine();

            if (END_COMMAND.equalsIgnoreCase(input)) {
                break;
            }

            lines.add(input);

            Matcher cratesM = CRATE_PATTERN.matcher(input);
            while (cratesM.find()) {
                crates++;
            }
        }

        if (crates == 0) {
            System.out.println(NO_SUPPLIES_FOUND);
            return;
        }

        int tagSymbols = crates / lines.size();

        long foodCollected = 0L;
        long drinksCollected = 0L;
        int supplyCrates = 0;

        for (String line : lines) {

            Matcher foods = FOOD_PATTERN.matcher(line);
            while (foods.find()) {
                if ((foods.group(TAG).length() == tagSymbols)) {

                    supplyCrates++;

                    long supplySum = foods.group(SUPPLY).chars()
                            .distinct()
                            .mapToLong(ch -> ch)
                            .sum();

                    foodCollected += supplySum * tagSymbols;
                }
            }

            Matcher drinks = DRINKS_PATTERN.matcher(line);
            while (drinks.find()) {
                if (drinks.group(TAG).length() == tagSymbols) {

                    supplyCrates++;

                    long tagSum = drinks.group(TAG).chars()
                            .mapToLong(ch -> ch)
                            .sum();

                    long supplySum = drinks.group(SUPPLY).chars()
                            .mapToLong(ch -> ch)
                            .sum();

                    drinksCollected += supplySum * tagSum;
                }
            }
        }

        if (supplyCrates > 0) {
            System.out.printf(NUMBER_OF_SUPPLY_CRATES, supplyCrates);
            System.out.printf(AMOUNT_OF_FOOD_COLLECTED, foodCollected);
            System.out.printf(AMOUNT_OF_DRINKS_COLLECTED, drinksCollected);
        } else {
            System.out.println(NO_SUPPLIES_FOUND);
        }
    }
}
