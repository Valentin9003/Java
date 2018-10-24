
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//Have a problem for judge tests only 10/100
public class DHARMAsupplies_Without_StreamAPI {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> suppliesList = new ArrayList<>();
        int linesCount = findAllSupplies(reader, suppliesList);

        int n = suppliesList.size() / linesCount;

        List<String> foodsList = new ArrayList<>();
        List<String> drinksList = new ArrayList<>();
        buildPatternsAndFindFoodsAndDrinks(suppliesList, n, foodsList, drinksList);

        long numberOfSupply = foodsList.size() + drinksList.size();
        long amountOfFood = calculateFoodAmount(foodsList, n);
        long amountOfDrinks = calculateDrinksAmount(drinksList, n);

        if (numberOfSupply > 0) {
            System.out.println(String.format("Number of supply crates: %d", numberOfSupply));
            System.out.println(String.format("Amount of food collected: %d", amountOfFood));
            System.out.println(String.format("Amount of drinks collected: %d", amountOfDrinks));
        } else {
            System.out.println("No supplies found!");
        }
    }

    private static long calculateDrinksAmount(List<String> drinksList, int n) {
        String drinksPattBuilder = String.format("%s%d%s", "[\\[](#[a-z]{", n, "})([A-Za-z0-9 ]+)\\1[\\]]") ;
        Pattern drinksPattern = Pattern.compile(drinksPattBuilder);

        long amount = 0L;
        for (String drink : drinksList) {
            Matcher matcher = drinksPattern.matcher(drink);
            if (matcher.find()) {
                String supplyTag = matcher.group(1).substring(1, matcher.group(1).length());
                String drinkName = matcher.group(2);
                amount += calculateAsciiSumFromString(drinkName) * calculateAsciiSumFromString(supplyTag);
            }
        }

        return amount;
    }

    private static long calculateFoodAmount(List<String> foodsList, int n) {
        String foodPattBuilder = String.format("%s%d%s", "[\\[](#[0-9]{", n, "})([A-Za-z0-9 ]+)\\1[\\]]");
        Pattern foodPattern = Pattern.compile(foodPattBuilder);

        long amount = 0L;
        for (String food : foodsList) {
            Matcher matcher = foodPattern.matcher(food);
            if (matcher.find()) {
                String foodName = matcher.group(2);
                long asciiSum = calculateAsciiSumFromString(foodName);
                amount += asciiSum * n;
            }
        }

        return  amount;
    }

    private static long calculateAsciiSumFromString(String foodName) {
        long sum = 0L;
        String temp = distinctChars(foodName);
        for (int i = 0; i < temp.length(); i++) {
            sum += temp.charAt(i);
        }
        return sum;
    }

    private static String distinctChars(String myString)
    {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < myString.length(); i++){
            char currentCh = myString.charAt(i);
            if (temp.toString().indexOf(currentCh) < 0){
                temp.append(currentCh);
            }
        }
        return temp.toString();
    }

    private static void buildPatternsAndFindFoodsAndDrinks(List<String> suppliesList, long n, List<String> foodsList, List<String> drinksList) {
        //need use Pattern.quote(yourString)
        String foodPattBuilder = String.format("%s%d%s", "[\\[](#[0-9]{", n, "})([A-Za-z0-9 ]+)\\1[\\]]");
        Pattern foodPattern = Pattern.compile(foodPattBuilder);
        String drinksPattBuilder = String.format("%s%d%s", "[\\[](#[a-z]{", n, "})([A-Za-z0-9 ]+)\\1[\\]]") ;
        Pattern drinksPattern = Pattern.compile(drinksPattBuilder);

        for (String supply : suppliesList) {
            Matcher foodMatcher = foodPattern.matcher(supply);
            if (foodMatcher.find()) {
                foodsList.add(foodMatcher.group());
            } else {
                Matcher drinksMatcher = drinksPattern.matcher(supply);
                if (drinksMatcher.find()) {
                    drinksList.add(drinksMatcher.group());
                }
            }
        }
    }

    private static int findAllSupplies(BufferedReader reader, List<String> suppliesList) throws IOException {
        Pattern suppliesPattern = Pattern.compile("[\\[](#[a-z0-9]+)([A-Za-z0-9\\s]+)\\1[]]");

        int linesCount = 0;
        String line;
        while (!"Collect".equalsIgnoreCase(line = reader.readLine())) {
            Matcher suppliesMatcher = suppliesPattern.matcher(line);
            while (suppliesMatcher.find()) {
                suppliesList.add(suppliesMatcher.group());

            }
            linesCount++;
        }
        return linesCount;
    }
}
