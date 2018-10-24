package p03_stackIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyStack<T> implements Iterable<T> {

    private final int INITIAL_CAPACITY = 16;
    private final int DEFAULT_ELEMENT_COUNT = 0;

    private T[] elements;
    private int elementCount;

    @SuppressWarnings("unchecked")
    public MyStack() {
        this.elements = (T[]) new Object[INITIAL_CAPACITY];
        this.elementCount = DEFAULT_ELEMENT_COUNT;
    }

    @SuppressWarnings("unchecked")
    public MyStack(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: "
                    + initialCapacity);
        }
        this.elements = (T[]) new Object[initialCapacity];
        this.elementCount = DEFAULT_ELEMENT_COUNT;
    }

    /**Increases the capacity of our collection
     * resize it with old length (elementCount) * 2 */
    private void grow() {
        this.elements = Arrays.copyOf(this.elements, (this.elementCount * 2));
    }

    /**The push method adds an element to the top of the collection*/
    /**If our collection if full -> need resize the collection *2 */
    /**Add the element and after that increase the elements count*/
    public void push(T element) {
        if (this.elements.length == this.elementCount) {
            this.grow();
        }
        this.elements[this.elementCount++] = element;
    }

    /**pop method returns the top element and removes it.
     * If collection is empty -> throw new NoSuchElementException()
     * Else getting the last element from collection,
     *      set this position on null and return the element.*/
    public T pop() {
        if (this.elementCount == 0) {
            throw new NoSuchElementException("No elements");
        }
        T element = this.elements[--this.elementCount];
        this.elements[this.elementCount] = null;
        return element;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private final class StackIterator implements Iterator<T> {

        private int cursor;

        public StackIterator() {
            this.cursor = elementCount - 1;
        }

        @Override
        public boolean hasNext() {
            return this.cursor >= 0;
        }

        @Override
        public T next() {
            return elements[this.cursor--];
        }
    }
}
