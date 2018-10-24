package p06_genericCountMethodDoubles;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>> {

    private T value;

    public Box(T value) {
        this.value = value;
    }

    @Override
    public int compareTo(Box<T> other) {
        return this.value.compareTo(other.value);
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.value.getClass().getName(), this.value);
    }
}
