package p03_iteratorTest;

import javax.naming.OperationNotSupportedException;
import java.util.List;

public class ListIterator {

    private final int DEFAULT_ITERNAL_INDEX_POINTING = 0;

    private List<String> collection;
    private int currentIndex;

    public ListIterator(List<String> collection) throws OperationNotSupportedException {
        this.setCollection(collection);
        this.currentIndex = DEFAULT_ITERNAL_INDEX_POINTING;
    }

    private void setCollection(List<String> collection) throws OperationNotSupportedException {
        if (collection == null) {
            throw new OperationNotSupportedException();
        }
        this.collection = collection;
    }

    public boolean move() {
        if (this.hasNext()) {
            this.currentIndex++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return this.currentIndex < this.collection.size() - 1;
    }

    public String print() {
        if (this.collection.size() == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        return this.collection.get(this.currentIndex);
    }
}
