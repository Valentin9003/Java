import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class HandOfCards {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, HashMap<String, Integer>> people = new LinkedHashMap<>();

        String input = reader.readLine();
        while (!input.equals("JOKER"))
        {
            String[]commandArr = input.split(":\\s");
            String name = commandArr[0];
            String[] cardsArr = commandArr[1].trim().split(",\\s");

            if (!people.containsKey(name))
            {
                people.put(name, new HashMap<>());
                addCardsToPersone(people.get(name), cardsArr);
            } else {
                addCardsToPersone(people.get(name), cardsArr);
            }

            input = reader.readLine();
        }

        for (String person : people.keySet()) {
            System.out.println(String.format("%s: %d", person, sumIntegersValue(people.get(person))));
        }

    }

    private static int sumIntegersValue(HashMap<String, Integer> stringIntegerHashMap)
    {
        int sum = 0;
        for (Integer value : stringIntegerHashMap.values())
        {
            sum += value;
        }
        return sum;
    }

    private static void addCardsToPersone(HashMap<String, Integer> person, String[] cardsArr)
    {
        for (String card : cardsArr) {
            if (!person.containsKey(card))
            {
                person.put(card, getCardValue(card));
            }
        }
    }

    private static Integer getCardValue(String card)
    {

        int power = 0;
        char check = card.charAt(0);
        switch (check)
        {
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                power += (int)card.charAt(0) - 48;
                break;
            case '1':
                power += 10;
                break;
            case 'J':
                power += 11;
                break;
            case 'Q':
                power += 12;
                break;
            case 'K':
                power += 13;
                break;
            case 'A':
                power += 14;
                break;
        }

        switch (card.charAt(card.length() - 1))
        {
            case 'S':
                power *= 4;
                break;
            case 'H':
                power *= 3;
                break;
            case 'D':
                power *= 2;
                break;
            case 'C':
                power *= 1;
                break;
        }
        return power;
    }
}
