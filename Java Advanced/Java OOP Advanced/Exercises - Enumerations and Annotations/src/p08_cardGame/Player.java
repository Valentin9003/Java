package p08_cardGame;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<Card> handOfCards;

    public Player(String name) {
        this.name = name;
        this.handOfCards = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addCard(Card card) {
        this.handOfCards.add(card);
    }

    public boolean isHandFull() {
        return this.handOfCards.size() == 5;
    }

    public Card getHighestPoweredCard() {
        Card card = this.handOfCards.get(0);
        for (int index = 1; index < this.handOfCards.size(); index++) {
            if (this.handOfCards.get(index).compareTo(card) > 0) {
                card = this.handOfCards.get(index);
            }
        }
        return card;
    }
}
