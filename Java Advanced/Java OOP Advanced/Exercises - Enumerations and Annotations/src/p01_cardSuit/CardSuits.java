package p01_cardSuit;

public enum CardSuits {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES;

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toUpperCase();
    }
}
