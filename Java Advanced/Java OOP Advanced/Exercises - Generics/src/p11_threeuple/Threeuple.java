package p11_threeuple;

public class Threeuple<T, E, R> {

    private T firstItem;
    private E secondItem;
    private R thirdItem;

    public Threeuple() {
    }

    public Threeuple(T firstItem, E secondItem, R thirdItem) {
        this.firstItem = firstItem;
        this.secondItem = secondItem;
        this.thirdItem = thirdItem;
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

    public R getThirdItem() {
        return this.thirdItem;
    }

    public void setThirdItem(R thirdItem) {
        this.thirdItem = thirdItem;
    }
}
