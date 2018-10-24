package bookshopsystem.services.interfaces;

import bookshopsystem.models.entity.Author;

import java.util.Date;
import java.util.List;

public interface AuthorService {

    void saveAuthorIntoDb(Author author);

    void saveAuthorsInDb(List<Author> authors);

    List<Author> getAllAuthors();

    List<Author> getAllWithBooksBefore(Date date);

    List<Author> authorsOrderByBooksCount();

    Author authorByFirstAndLastName(String fName, String lName);
}
