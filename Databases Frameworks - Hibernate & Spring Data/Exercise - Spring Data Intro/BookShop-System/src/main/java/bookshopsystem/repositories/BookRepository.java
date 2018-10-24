package bookshopsystem.repositories;

import bookshopsystem.models.entity.Author;
import bookshopsystem.models.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAllByReleaseDateAfter(Date releaseDate);

    List<Book> findAllByAuthor(Author author);

    List<Book> findAllByAuthorAndReleaseDateBefore(Author author, Date date);

    List<Book> findAllByAuthorOrderByReleaseDateDescTitleAsc(Author author);
}
