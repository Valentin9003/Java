package p03_comparableBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {

    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setAuthors(String... authors) {
        this.authors = new ArrayList<>(Arrays.asList(authors));
    }

    private void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public int compareTo(Book other) {
        if (this.getTitle().compareTo(other.getTitle()) < 0) {
            return 1;
        } else if (this.getTitle().compareTo(other.getTitle()) > 0) {
            return -1;
        }

        return Integer.compare(this.getYear(), other.getYear());
    }

    @Override
    public String toString() {
        return String.format("Book Title: %s Year: %d Authors: %s",
                this.getTitle(),
                this.getYear(),
                String.join(", ", this.getAuthors()));
    }
}
