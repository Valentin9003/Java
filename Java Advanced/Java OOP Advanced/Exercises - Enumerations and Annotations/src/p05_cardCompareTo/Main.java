package p05_cardCompareTo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstCardRank = reader.readLine();
        String firstCardSuit = reader.readLine();

        String secondCardRank = reader.readLine();
        String secondCardSuit = reader.readLine();

        try {
            Card firstCard = new Card(firstCardRank, firstCardSuit);
            Card secondCard = new Card(secondCardRank, secondCardSuit);

            int comp = firstCard.compareTo(secondCard);
            Card winner = comp > 0 ? firstCard : secondCard;

            System.out.println(String.format("Card name: %s; Card power: %d",
                    winner.toString(),
                    winner.getPower()));
        } catch (IllegalArgumentException ignored) {
            ;
        }
    }
}
