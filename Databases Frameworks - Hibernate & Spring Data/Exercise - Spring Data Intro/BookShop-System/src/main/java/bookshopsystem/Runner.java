package bookshopsystem;

import bookshopsystem.enums.AgeRestriction;
import bookshopsystem.enums.EditionType;
import bookshopsystem.models.entity.Author;
import bookshopsystem.models.entity.Book;
import bookshopsystem.models.entity.Category;
import bookshopsystem.services.interfaces.AuthorService;
import bookshopsystem.services.interfaces.BookService;
import bookshopsystem.services.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class Runner implements CommandLineRunner {

    private static final String AUTHORS_RESOURCE_FILE = "C:\\Users\\Admin\\Desktop\\IntroToHibernateResources\\BookShop-System\\src\\main\\resources\\authors.txt";
    private static final String CATEGORIES_RESOURCE_FILE = "C:\\Users\\Admin\\Desktop\\IntroToHibernateResources\\BookShop-System\\src\\main\\resources\\categories.txt";
    private static final String BOOKS_RESOURCES_FILE = "C:\\Users\\Admin\\Desktop\\IntroToHibernateResources\\BookShop-System\\src\\main\\resources\\books.txt";

    private AuthorService authorService;
    private CategoryService categoryService;
    private BookService bookService;

    @Autowired
    public Runner(AuthorService authorService, CategoryService categoryService, BookService bookService){
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... strings) throws Exception {
//        initAuthors();
//        initCategories();
//        initBooks();

        getAllBooksAfterYear();
        allAuthorsWithAtLeastOneBookAfterYear();
        getAllAuthorsOrderByNumberOfBooks();
        getAllBooksFromAuthorOrdered("George Powell");
    }

    private void allAuthorsWithAtLeastOneBookAfterYear() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("1990-01-01");

        List<Author> authors = this.authorService.getAllWithBooksBefore(date);

        for (Author author : authors) {
            System.out.println(author.getFirstName() + " " + author.getLastName());
            System.out.println("-------------------------");

            this.bookService.allByAuthorAndReleaseDateBefore(author, date)
                    .forEach(book -> {
                System.out.println(" - Title: " + book.getTitle() + " ReleaseDate: " + book.getReleaseDate());
            });
            System.out.println();
        }
    }

    private void initBooks() throws IOException, ParseException {
        BufferedReader booksReader = new BufferedReader(new FileReader(BOOKS_RESOURCES_FILE));

        List<Author> authors = this.authorService.getAllAuthors();
        List<Category> categories = this.categoryService.getAllCategories();

        String line = booksReader.readLine();
        while ((line = booksReader.readLine()) != null) {
            String[] data = line.split("\\s+");
            Random random = new Random();

            int authorIndex = random.nextInt(authors.size());
            Author author = authors.get(authorIndex);

            //TODO add random categories for current book....its ready
            int categoryIndex = random.nextInt(categories.size());
            Category category = categories.get(categoryIndex);
            Set<Category> categoriesSet = new HashSet<>();
            categoriesSet.add(category);

            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];

            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
            Date releaseDate = formatter.parse(data[1]);

            int copies = Integer.parseInt(data[2]);

            BigDecimal price = new BigDecimal(data[3]);

            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];

            StringBuilder titleBuilder = new StringBuilder();
            for (int i = 5; i < data.length; i++) {
                titleBuilder.append(data[i]).append(" ");
            }
            titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
            String title = titleBuilder.toString();

            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);
            book.setCategories(categoriesSet);

            this.bookService.saveBookInToDb(book);
        }
    }

    private void initCategories() throws IOException {
        List<String> categoriesList = Files.readAllLines(Paths.get(CATEGORIES_RESOURCE_FILE));

        List<Category> categories =
                categoriesList.stream()
                        .filter(s -> !s.isEmpty())
                        .map(Category::new)
                        .collect(Collectors.toList());

        this.categoryService.saveCategoriesInToDb(categories);
    }

    private void initAuthors() throws IOException {
        List<String> authorsList = Files.readAllLines(Paths.get(AUTHORS_RESOURCE_FILE));

        List<Author> authors =
                authorsList.stream().map(s -> {
                    String[] authorName = s.split("\\s+");
                    return new Author(authorName[0], authorName[1]);
                }).collect(Collectors.toList());

        this.authorService.saveAuthorsInDb(authors);
    }

    private void getAllBooksAfterYear() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2000-12-31");

        System.out.println("-------------------------------------");
        System.out.println("|   Book Title   |   Release Date   |");
        System.out.println("-------------------------------------");
        this.bookService.allTitlesAfterYear(date)
                .forEach(book -> {
                    System.out.println(String.format("%s  |  %s",
                            book.getTitle(), book.getReleaseDate()));
                });
        System.out.println();

    }

    public void getAllAuthorsOrderByNumberOfBooks() {
        System.out.println("-----------------------------");
        System.out.println("|   Author   -  Book Count  |");
        System.out.println("-----------------------------");
        this.authorService.authorsOrderByBooksCount()
                .forEach(author -> {
                    System.out.println(String.format("%s %s - %d",
                            author.getFirstName(), author.getLastName(), author.getBooks().size()));
                });
    }

    public void getAllBooksFromAuthorOrdered(String fullName) {
        String[] name = fullName.split("\\s+");
        Author author = this.authorService.authorByFirstAndLastName(name[0], name[1]);

        this.bookService.allByAuthorOrderByReleaseDateDescTitleAsc(author)
                .forEach(book -> {
                    System.out.println(String.format("Book Title: %s%n   Release Date: %s%n   Copies: %d",
                            book.getTitle(), book.getReleaseDate(), book.getCopies()));
                });

    }
}
