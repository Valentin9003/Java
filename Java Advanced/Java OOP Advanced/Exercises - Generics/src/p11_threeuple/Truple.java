package p11_threeuple;

public class Truple<T, E> {

    private T firstItem;
    private E secondItem;

    public Truple() {
    }

    public Truple(T item1, E item2) {
        this.firstItem = item1;
        this.secondItem = item2;
    }

    public void setFirstItem(T firstItem) {
        this.firstItem = firstItem;
    }

    public T getFirstItem() {
        return this.firstItem;
    }

    public void setSecondItem(E secondItem) {
        this.secondItem = secondItem;
    }

    public E getSecondItem() {
        return this.secondItem;
    }
}
