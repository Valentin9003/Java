package p09_customListIterator.model.impl;

import p09_customListIterator.model.interfaces.MyList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MyListImpl<T extends Comparable<T>> implements MyList<T> {

    private List<T> myList;

    public MyListImpl() {
        this.myList = new ArrayList<>();
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < this.myList.size();
    }

    @Override
    public void add(T element) {
        this.myList.add(element);
    }

    @Override
    public T remove(int index) {
        if (isValidIndex(index)) {
            this.myList.remove(index);
        }
        return null;
    }

    @Override
    public boolean contains(T element) {
        return this.myList.contains(element);
    }

    @Override
    public void swap(int firstIndex, int secondIndex) {
        if (isValidIndex(firstIndex) && isValidIndex(secondIndex)) {
            T temp = this.myList.get(firstIndex);
            this.myList.set(firstIndex, this.myList.get(secondIndex));
            this.myList.set(secondIndex, temp);
        }
    }

    @Override
    public int countGreaterThan(T element) {
        int count = 0;
        for (T t : this.myList) {
            if (t.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    @Override
    public T getMax() {
        return Collections.max(this.myList);
    }

    @Override
    public T getMin() {
        return Collections.min(this.myList);
    }

    @Override
    public Iterator<T> getCollection() {
        return this.myList.iterator();
    }

    @Override
    public void sortAsc() {
        Collections.sort(this.myList);
    }
}
