package bookshopsystem.repositories;

import bookshopsystem.dto.AuthorDto;
import bookshopsystem.dto.BookDto;
import bookshopsystem.dto.ReducedBook;
import bookshopsystem.enums.AgeRestriction;
import bookshopsystem.enums.EditionType;
import bookshopsystem.models.entity.Author;
import bookshopsystem.models.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAllByReleaseDateAfter(Date releaseDate);

    List<Book> findAllByAuthor(Author author);

    List<Book> findAllByAuthorAndReleaseDateBefore(Author author, Date date);

    List<Book> findAllByAuthorOrderByReleaseDateDescTitleAsc(Author author);

    @Query(value = "SELECT b.title FROM Book b WHERE b.ageRestriction = :restriction")
    List<String> allBooksByRestriction(@Param("restriction") AgeRestriction restriction);

    @Query(value = "SELECT b.title FROM Book b WHERE b.copies < 5000 AND b.editionType = :edition")
    List<String> allGoldenEditionBooksWithLessThan5000Copies(@Param("edition") EditionType editionType);

    @Query("SELECT new bookshopsystem.dto.BookDto(b.title, b.price) FROM Book b WHERE b.price < 5 OR b.price > 40")
    List<BookDto> allBooksByPrice();

    @Query(value = "SELECT b.title FROM Book b WHERE b.releaseDate <> :date")
    List<String> notReleasedBooksOnGivenYear(@Param("date") Date date);

    @Query("SELECT new bookshopsystem.dto.BookDto(b.title, b.price, b.editionType) FROM Book b WHERE b.releaseDate < :date")
    List<BookDto> booksReleasedBeforeDate(@Param("date") Date date);

    List<Book> findAllByTitleContains(String str);

    @Query("SELECT b FROM Book b WHERE b.author.lastName LIKE :str")
    List<Book> bookTitleSearchByAuthorLastNameStartingWith(@Param("str") String str);

    @Query("SELECT count(b.title) FROM Book b WHERE length(b.title) > :number")
    int countBookByTitleGreaterThan(@Param("number") Integer number);

    @Query("SELECT " +
            "new bookshopsystem.dto.AuthorDto(b.author.firstName, b.author.lastName, sum(b.copies))" +
            "FROM Book b " +
            "GROUP BY b.author.firstName, b.author.lastName")
    List<AuthorDto> totalBookCopiesByAuthors();

    ReducedBook findBookByTitle(String title);

    @Modifying
    @Query("UPDATE Book b SET b.copies = b.copies + :newCopies WHERE b.releaseDate > :date")
    int increaseBookCopies(@Param("date") Date date, @Param("newCopies") int newCopies);

    @Modifying
    int removeBooksByCopiesLessThan(int number);

}
