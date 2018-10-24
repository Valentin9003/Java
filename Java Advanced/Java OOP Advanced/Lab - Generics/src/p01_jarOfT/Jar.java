package p01_jarOfT;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {

    private Deque<T> jarStorage;

    public Jar() {
        this.jarStorage = new ArrayDeque<>();
    }

    public void add(T e) {
        this.jarStorage.push(e);
    }

    public T remove() {
        return this.jarStorage.pop();
    }
}
