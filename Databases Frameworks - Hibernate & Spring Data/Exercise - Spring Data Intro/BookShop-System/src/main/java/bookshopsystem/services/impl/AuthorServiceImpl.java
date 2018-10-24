package bookshopsystem.services.impl;

import bookshopsystem.models.entity.Author;
import bookshopsystem.repositories.AuthorRepository;
import bookshopsystem.services.interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public void saveAuthorIntoDb(Author author) {
        this.authorRepository.saveAndFlush(author);
    }

    @Override
    public void saveAuthorsInDb(List<Author> authors) {
        this.authorRepository.save(authors);
    }

    @Override
    public List<Author> getAllAuthors() {
        return this.authorRepository.findAll();
    }

    @Override
    public List<Author> getAllWithBooksBefore(Date date) {
        return this.authorRepository.findAllAuthorsWithBooksBefore(date);
    }

    @Override
    public List<Author> authorsOrderByBooksCount() {
        return this.authorRepository.authorsOrderByBooksCount();
    }

    @Override
    public Author authorByFirstAndLastName(String fName, String lName) {
        return this.authorRepository.findAuthorByFirstNameAndLastName(fName, lName);
    }
}
