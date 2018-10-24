package bookshopsystem.services.bookService;

import bookshopsystem.dto.AuthorDto;
import bookshopsystem.dto.BookDto;
import bookshopsystem.dto.ReducedBook;
import bookshopsystem.enums.AgeRestriction;
import bookshopsystem.enums.EditionType;
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

    List<String> allBooksByRestriction(AgeRestriction restriction);

    List<String> allGoldenEditionBooksWithLessThan5000Copies(EditionType editionType);

    List<BookDto> allBooksByPrice();

    List<String> notReleasedBooksOnGivenYear(Date date);

    List<BookDto> booksReleasedBeforeDate(Date date);

    List<Book> findAllByTitleContains(String str);

    List<Book> bookTitleSearchByAuthorLastNameStartingWith(String str);

    int countBookByTitleGreaterThan(Integer number);

    List<AuthorDto> totalBookCopiesByAuthors();

    ReducedBook findBookByTitle(String title);

    int increaseBookCopies( Date date, int newCopies);

    int removeBooksByCopiesLessThan(int number);

}
