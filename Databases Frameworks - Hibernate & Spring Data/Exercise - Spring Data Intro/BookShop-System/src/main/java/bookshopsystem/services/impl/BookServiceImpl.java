package bookshopsystem.services.impl;

import bookshopsystem.models.entity.Author;
import bookshopsystem.models.entity.Book;
import bookshopsystem.repositories.BookRepository;
import bookshopsystem.services.interfaces.BookService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public void saveBookInToDb(Book book) {
        this.bookRepository.saveAndFlush(book);
    }

    @Override
    public List<Book> allTitlesAfterYear(Date year) {
        return this.bookRepository.findAllByReleaseDateAfter(year);
    }

    @Override
    public List<Book> allBooksByAuthor(Author author) {
        return this.bookRepository.findAllByAuthor(author);
    }

    @Override
    public List<Book> allByAuthorAndReleaseDateBefore(Author author, Date date) {
        return this.bookRepository.findAllByAuthorAndReleaseDateBefore(author, date);
    }

    @Override
    public List<Book> allByAuthorOrderByReleaseDateDescTitleAsc(Author author) {
        return this.bookRepository.findAllByAuthorOrderByReleaseDateDescTitleAsc(author);
    }
}
