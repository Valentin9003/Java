package p04_froggy;

import java.util.Iterator;

public class Lake implements Iterable<Integer> {

    private int[] elements;

    @SafeVarargs
    public Lake(int... elements) {
        this.elements = elements;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<Integer> {

        private int index;

        @Override
        public boolean hasNext() {
            if (this.index % 2 == 0) {
                return true;
            }
            return this.index < elements.length;
        }

        @Override
        public Integer next() {
            int element = elements[this.index];
            this.index += 2;
            if (this.index % 2 == 0 && this.index >= elements.length) {
                this.index = 1;
            }
            return element;
        }
    }
}
