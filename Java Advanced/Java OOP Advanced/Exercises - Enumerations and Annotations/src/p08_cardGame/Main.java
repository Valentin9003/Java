package p08_cardGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Player firstPlayer = new Player(reader.readLine());
        Player secondPlayer = new Player(reader.readLine());

        CardGame game = new CardGame(firstPlayer, secondPlayer);
        Deck cardDeck = new Deck();

        while (true) {
            if (firstPlayer.isHandFull() && secondPlayer.isHandFull()) {
                break;
            }

            String[] cardTokens = reader.readLine().split(" of ");
            String rank = cardTokens[0];
            String suit = cardTokens[1];

            Card card;
            try {
                card = new Card(rank, suit);
            } catch (IllegalArgumentException iae) {
                /**For 100/100 in Judge use System.out.println(...)*/
                System.err.println("No such card exists.");
                continue;
            }

            if (!cardDeck.contains(card)) {
                /**For 100/100 in Judge use System.out.println(...)*/
                System.err.println("Card is not in the deck.");
                continue;
            }

            cardDeck.removeCard(card);

            if (!firstPlayer.isHandFull()) {
                firstPlayer.addCard(card);
            } else if (!secondPlayer.isHandFull()) {
                secondPlayer.addCard(card);
            }
        }

        Player winner = game.getWinner();
        System.out.println(String.format("%s wins with %s.",
                winner.getName(),
                winner.getHighestPoweredCard().toString()));
    }
}
