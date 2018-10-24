package bookshopsystem.services.interfaces;

import bookshopsystem.models.entity.Author;
import bookshopsystem.models.entity.Book;

import java.util.Date;
import java.util.List;

public interface BookService {

    void saveBookInToDb(Book book);

    List<Book> allTitlesAfterYear(Date year);

    List<Book> allBooksByAuthor(Author author);

    List<Book> allByAuthorAndReleaseDateBefore(Author author, Date date);

    List<Book> allByAuthorOrderByReleaseDateDescTitleAsc(Author author);
}
