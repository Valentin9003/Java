package p02_cardRank;

public enum CardRank {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING;


    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toUpperCase();
    }
}
