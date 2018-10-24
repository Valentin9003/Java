package p02_library;

import java.util.Iterator;

public class Library<Book> implements Iterable<Book> {

    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        //return our Iterator class
        return new LibIterator();

//        return Arrays.asList(this.books).iterator();
    }

    /**
     * Nested (inner) class Iterator -> if we want to implement
     * exactly how will iterate over our collection
     */
    private final class LibIterator implements Iterator<Book> {

        private final int DEFAULT_INDEX = 0;

        private int index;

        public LibIterator() {
            this.index = DEFAULT_INDEX;
        }

        @Override
        public boolean hasNext() {
            return this.index < books.length;
        }

        @Override
        public Book next() {
            return books[this.index++];
        }
    }
}
