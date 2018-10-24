package p07_deckOfCards;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    
    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        seedCards();
    }

    public Iterable<Card> iterable() {
        return this.cards;
    }

    private void seedCards() {
        for (CardSuits suits : CardSuits.values()) {
            for (CardRank rank : CardRank.values()) {
                this.cards.add(new Card(rank.name(), suits.name()));
            }
        }
    }
}
