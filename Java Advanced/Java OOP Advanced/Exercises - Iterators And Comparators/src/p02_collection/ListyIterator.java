package p02_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator<T> implements Iterable<T> {

    private final String EMPTY_COLLECTION_EXCEPTION_MESSAGE = "Invalid Operation!";
    private final int DEFAULT_INDEX = 0;

    private List<T> collection;
    private int internalIndex;

    public ListyIterator(T... collection) {
        this.collection = new ArrayList<>(Arrays.asList(collection));
        this.internalIndex = DEFAULT_INDEX;
    }

    public boolean move(){
        if (hasNext()) {
            this.internalIndex++;
            return true;
        }
        return false;
    }

    public boolean hasNext(){
        return this.internalIndex < this.collection.size() - 1;
    }

    public void print(){
        if (this.collection.size() == 0) {
            throw new IllegalArgumentException(EMPTY_COLLECTION_EXCEPTION_MESSAGE);
        }
        System.out.println(this.collection.get(this.internalIndex));
    }

    public void printAll() {
        for (T t : this) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        return this.collection.iterator();
    }
}
