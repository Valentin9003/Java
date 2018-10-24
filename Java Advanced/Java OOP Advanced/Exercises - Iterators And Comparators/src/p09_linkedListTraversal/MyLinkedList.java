package p09_linkedListTraversal;

import java.util.Arrays;
import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T>, LinkedListTraversal<T> {

    private final int DEFAULT_COLLECTION_SIZE = 16;
    private final int DEFAULT_ELEMENTS_COUNT = 0;

    private T[] elements;
    private int elementsCount;

    @SuppressWarnings("unchecked")
    public MyLinkedList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: "
                    + initialCapacity);
        }
        this.elements = (T[]) new Object[initialCapacity];
        this.elementsCount = DEFAULT_ELEMENTS_COUNT;
    }

    @SuppressWarnings("unchecked")
    public MyLinkedList() {
        this.elements = (T[]) new Object[DEFAULT_COLLECTION_SIZE];
        this.elementsCount = DEFAULT_ELEMENTS_COUNT;
    }

    /**
     * Increases the capacity of our collection
     * resize it with old length (elementCount) * 2
     */
    private void grow() {
        this.elements = Arrays.copyOf(this.elements, (this.elementsCount * 2));
    }

    /**
     * The add method should add the new element
     * at the end of the collection.
     */
    @Override
    public void add(T newElement) {
        if (this.elementsCount >= this.elements.length) {
            this.grow();
        }
        this.elements[this.elementsCount++] = newElement;
    }

    /**
     * The remove method should remove the first occurrence of the item
     * starting at the beginning of the collection,
     * if the element is succesfully removed the method returns true,
     * alternatively if the element passed is not in the collection
     * the method should return false.
     */
    @Override
    public boolean remove(T element) {
        for (int i = 0; i < this.elementsCount; i++) {
            if (this.elements[i] == element) {
                this.elementsCount--;
                removeFirstOccurrenceElement(i);
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    private void removeFirstOccurrenceElement(int firstOccurrenceIndex) {
        T[] newCollection = (T[]) new Object[this.elements.length];
        for (int i = 0, indexOldCollection = 0; i < this.elementsCount; i++, indexOldCollection++) {
            if (indexOldCollection == firstOccurrenceIndex) {
                indexOldCollection++;
            }
            newCollection[i] = this.elements[indexOldCollection];
        }
        this.elements = Arrays.copyOf(newCollection, (this.elementsCount * 2));
    }

    /**The getSize method should return the number of
     * elements currently in the collection*/
    @Override
    public int getSize() {
        return this.elementsCount;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    /**The iterator should iterate over the collection
     * starting from the first entered element.*/
    private final class LinkedListIterator implements Iterator<T> {

        private int currentIndex;

        public LinkedListIterator() {
            this.currentIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return this.currentIndex < elementsCount;
        }

        @Override
        public T next() {
            return elements[this.currentIndex++];
        }
    }
}
