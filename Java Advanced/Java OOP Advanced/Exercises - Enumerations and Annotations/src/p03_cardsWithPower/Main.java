package p03_cardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String cardRank = reader.readLine();
        String cardSuit = reader.readLine();

        try {
            Card card = new Card(cardRank, cardSuit);

            System.out.println(String.format("Card name: %s; Card power: %d",
                    card.toString(),
                    card.getPower()));
        } catch (IllegalArgumentException ignored) {
            ;
        }
    }
}
