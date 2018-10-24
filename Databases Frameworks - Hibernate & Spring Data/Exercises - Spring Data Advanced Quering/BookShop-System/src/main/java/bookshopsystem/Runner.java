package bookshopsystem;

import bookshopsystem.dto.AuthorDto;
import bookshopsystem.dto.ReducedBook;
import bookshopsystem.enums.AgeRestriction;
import bookshopsystem.enums.EditionType;
import bookshopsystem.models.entity.Author;
import bookshopsystem.models.entity.Book;
import bookshopsystem.models.entity.Category;
import bookshopsystem.services.authorService.AuthorService;
import bookshopsystem.services.bookService.BookService;
import bookshopsystem.services.categoryService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Transactional
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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Exercises: Spring Data Intro -->
//        initAuthors();
//        initCategories();
//        initBooks();

//        getAllBooksAfterYear();
//        allAuthorsWithAtLeastOneBookAfterYear();
//        getAllAuthorsOrderByNumberOfBooks();
//        getAllBooksFromAuthorOrdered("George Powell");

        //Exercises: Spring Data Advanced Quering -->
//        bookTitleByAgeRestriction(reader.readLine().toUpperCase());
//        goldenBooks();
//        booksByPrice();
//        notReleasedBooks(reader.readLine());
//        booksReleasedBeforeDate(reader.readLine());
//        authorsSearch(reader.readLine());
//        bookSearch(reader.readLine());
//        bookTitleSearch(reader.readLine());
//        countBooksByLongerTitle(Integer.parseInt(reader.readLine()));
//        totalBookCopiesByAuthor();
//        reducedBook(reader.readLine());
//        increaseBookCopies(reader);
//         removeBooks(Integer.parseInt(reader.readLine()));
        storedProcedure(reader.readLine());
    }

    private void storedProcedure(String authorFullName) {
        String[] name = authorFullName.trim().split("\\s+");
        int authorBooksCount = this.authorService.getAuthorBookCountProcedure(name[0], name[1]);

//        AuthorDto authorDto = this.authorService.callStoredProcedure("Amanda", "Rice");
//        String debug = "";

        if (authorBooksCount > 1) {
            System.out.println(authorFullName + " has written " + authorBooksCount + " books");
        } else if (authorBooksCount == 1) {
            System.out.println(authorFullName + " has written " + authorBooksCount + " book");
        } else {
            System.out.println(authorFullName + " has not written any books yet");
        }

    }

    private void removeBooks(int copies) {
        int affectedBooks = this.bookService.removeBooksByCopiesLessThan(copies);

        System.out.println(String.format("%d books were deleted", affectedBooks));
    }

    private void increaseBookCopies(BufferedReader reader) throws IOException, ParseException {
        String dateStr = reader.readLine();
        SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy"); //Don't work with patter "dd MMM yyyy"
        Date date = format.parse(dateStr);
        int newCopies = Integer.parseInt(reader.readLine());

        int affectedBooks = this.bookService.increaseBookCopies(date, newCopies);
//        String debug ="";
        long addedCopies = newCopies * affectedBooks;
        System.out.println(
                String.format("%d books are released after %s so total of %d book copies were added",
                        affectedBooks, dateStr, addedCopies));
    }

    private void reducedBook(String title) {
        ReducedBook book = this.bookService.findBookByTitle(title);
        System.out.println(String.format("Title: %s | EditionType: %s | AgeRestriction: %s | Price: %.2f",
                book.getTitle(), book.getEditionType(), book.getAgeRestriction(), book.getPrice()));
    }

    private void totalBookCopiesByAuthor() {
        this.bookService.totalBookCopiesByAuthors().forEach(a -> {
            System.out.println(String.format("%s - %d",
                    a.getFullName(), a.getSumCopies()));
        });
    }

    private void countBooksByLongerTitle(int number) {
        int booksCount = this.bookService.countBookByTitleGreaterThan(number);
        System.out.println(String.format(
                "There are %d books with longer title than %d symbols",
                booksCount, number));
    }

    private void bookTitleSearch(String str) {
        this.bookService.bookTitleSearchByAuthorLastNameStartingWith(str).forEach(b -> {
            System.out.println(String.format("%s ( %s )", b.getTitle(), b.getAuthor().getFullName()));
        });
    }

    private void bookSearch(String str) {
        this.bookService.findAllByTitleContains(str).forEach(b -> {
            System.out.println(b.getTitle());
        });
    }

    private void authorsSearch(String str) {
        this.authorService.findAllByFirstNameEndingWith(str).forEach(a -> {
            System.out.println(String.format("%s %s", a.getFirstName(), a.getLastName()));
        });
    }

    private void booksReleasedBeforeDate(String dataString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date date = format.parse(dataString);

        this.bookService.booksReleasedBeforeDate(date).forEach(System.out::println);
    }

    private void notReleasedBooks(String dataString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        Date date = format.parse(dataString);

        this.bookService.notReleasedBooksOnGivenYear(date).forEach(System.out::println);
    }

    private void booksByPrice() {
        this.bookService.allBooksByPrice().forEach(b -> {
            System.out.println(String.format("%s - $%.2f", b.getTitle(), b.getPrice()));
        });
    }

    private void goldenBooks() {
        this.bookService.allGoldenEditionBooksWithLessThan5000Copies(EditionType.GOLD)
                .forEach(System.out::println);
    }

    private void bookTitleByAgeRestriction(String restriction) {
        AgeRestriction ageRestriction = AgeRestriction.valueOf(restriction);
        this.bookService.allBooksByRestriction(ageRestriction).forEach(System.out::println);
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
