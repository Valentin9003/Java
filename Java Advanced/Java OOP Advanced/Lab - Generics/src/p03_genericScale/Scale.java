package p03_genericScale;

public class Scale<T extends Comparable> {

    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getLeft() {
        return this.left;
    }

    public T getRight() {
        return this.right;
    }

    public T getHeavier() {
        int compare = this.getLeft().compareTo(this.getRight());
        return compare > 0 ? this.getLeft() : compare < 0 ? this.getRight() : null;
    }
}
