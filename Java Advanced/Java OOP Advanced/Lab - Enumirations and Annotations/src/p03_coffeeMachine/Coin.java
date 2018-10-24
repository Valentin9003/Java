package p03_coffeeMachine;

public enum Coin {
    ONE(1), TWO(2), FIVE(5), TEN(10), TWENTY(20), FIFTY(50);

    private int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}
