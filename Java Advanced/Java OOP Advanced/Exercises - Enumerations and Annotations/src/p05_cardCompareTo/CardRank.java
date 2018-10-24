package p05_cardCompareTo;

public enum CardRank {
    ACE(14),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private int power;

    CardRank(int value) {
        this.power = value;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toUpperCase();
    }
}
