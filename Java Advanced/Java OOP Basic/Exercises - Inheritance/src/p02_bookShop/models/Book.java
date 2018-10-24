package p02_bookShop.models;

public class Book {

    private static final String INVALID_AUTHOR_NAME_EX_MSG = "Author not valid!";
    private static final String INVALID_TITLE_LENGTH_EX_MSG = "Title not valid!";
    private static final String INVALID_PRICE_EX_MSG = "Price not valid!";

    private String title;
    private String author;
    private double price;

    public Book(String author, String title, double price) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPrice(price);
    }

    public String getTitle() {
        return this.title;
    }

    protected void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException(INVALID_TITLE_LENGTH_EX_MSG);
        }
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    protected void setAuthor(String author) {
        if (author.matches("\\b[A-Za-z]+\\s[0-9]{1,}[A-Za-z]+\\b")) {
            throw new IllegalArgumentException(INVALID_AUTHOR_NAME_EX_MSG);
        }
        this.author = author;
    }

    public double getPrice() {
        return this.price;
    }

    protected void setPrice(double price) {
        if (price < 1) {
            throw new IllegalArgumentException(INVALID_PRICE_EX_MSG);
        }
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());
        return sb.toString();
    }
}
