import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class HandScore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> cardsPower = new HashMap<String, Integer>() {
            {
                put("2", 2);
                put("3", 3);
                put("4", 4);
                put("5", 5);
                put("6", 6);
                put("7", 7);
                put("8", 8);
                put("9", 9);
                put("10", 10);
                put("J", 12);
                put("Q", 13);
                put("K", 14);
                put("A", 15);
            }
        };

        Deque<String> playerHand =
                Arrays.stream(reader.readLine()
                        .split("\\s+"))
                        .collect(Collectors.toCollection(ArrayDeque::new));

        int power = 0;
        while (!playerHand.isEmpty()) {
            String card = playerHand.pop();
            int counter = 1;
            int currentPower = getCurrentCardPower(card, cardsPower);

            while ((playerHand.size() >= 1) && nextCardIsFromSameType(playerHand, card)) {
                card = playerHand.pop();
                currentPower += getCurrentCardPower(card, cardsPower);
                counter++;
            }

            power += currentPower * counter;
        }

        System.out.println(power);
    }

    private static boolean nextCardIsFromSameType(Deque<String> playerHand, String card) {
        String[] currentCardTokens = card.split("");
        String[] nextCardType = playerHand.getFirst().split("");

        int ccLastIndex = currentCardTokens.length - 1;
        int ncLastIndex = nextCardType.length - 1;

        return currentCardTokens[ccLastIndex].equals(nextCardType[ncLastIndex]);
    }

    private static int getCurrentCardPower(String card, Map<String, Integer> cardsPower) {
        int power = 0;
        for (String key : cardsPower.keySet()) {
            if (card.startsWith(key)) {
                power += cardsPower.get(key);
            }
        }
        return power;
    }

}
