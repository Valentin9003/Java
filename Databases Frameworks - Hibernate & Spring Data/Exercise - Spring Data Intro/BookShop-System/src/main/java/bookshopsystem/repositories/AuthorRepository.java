package bookshopsystem.repositories;

import bookshopsystem.models.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a INNER JOIN a.books b WHERE b.releaseDate <= ?1")
    List<Author> findAllAuthorsWithBooksBefore(Date date);

    @Query("SELECT a FROM Author a ORDER BY a.books.size DESC")
    List<Author> authorsOrderByBooksCount();

    Author findAuthorByFirstNameAndLastName(String fName, String lName);
}
