package bookshopsystem.dto;

import bookshopsystem.enums.EditionType;
import bookshopsystem.models.entity.Author;

import java.math.BigDecimal;

public class BookDto {

    private String title;
    private BigDecimal price;
    private EditionType editionType;
    private Author author;
    private String aFirstName;
    private String aLastName;
    private Integer booksCount;

    public BookDto() {
    }

    public BookDto(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
    }

    public BookDto(String title, BigDecimal price, EditionType editionType) {
        this.title = title;
        this.price = price;
        this.editionType = editionType;
    }

    public BookDto(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public BookDto(String aFirstName, String aLastName, Integer booksCount) {
        this.aFirstName = aFirstName;
        this.aLastName = aLastName;
        this.booksCount = booksCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public EditionType getEditionType() {
        return editionType;
    }

    public void setEditionType(EditionType editionType) {
        this.editionType = editionType;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("TITLE: %s  EDITION TYPE: %s  PRICE: $%.2f",
                this.getTitle(), this.getEditionType(), this.getPrice());
    }

    public String getaFirstName() {
        return aFirstName;
    }

    public void setaFirstName(String aFirstName) {
        this.aFirstName = aFirstName;
    }

    public String getaLastName() {
        return aLastName;
    }

    public void setaLastName(String aLastName) {
        this.aLastName = aLastName;
    }

    public Integer getBooksCount() {
        return booksCount;
    }

    public void setBooksCount(Integer booksCount) {
        this.booksCount = booksCount;
    }
}
