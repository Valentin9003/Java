package p02_bookShop;

import p02_bookShop.models.Book;
import p02_bookShop.models.GoldenEditionBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.Method;

public class Main {

    private static final String CODE_DUPLICATION_EX_MESSAGE = "Code duplication in GoldenEditionBook!";

    public static void main(String[] args) throws IllegalClassFormatException {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String author = reader.readLine();
            String title = reader.readLine();
            double price = Double.valueOf(reader.readLine());

            Book book = new Book(author, title, price);

            GoldenEditionBook goldenEditionBook = new GoldenEditionBook(author, title, price);

            Method[] goldenBookDeclaredMethods =
                    GoldenEditionBook.class.getDeclaredMethods();

            if (goldenBookDeclaredMethods.length > 1) {
                throw new IllegalClassFormatException(CODE_DUPLICATION_EX_MESSAGE);
            }

            System.out.println(book.toString());
            System.out.println(goldenEditionBook.toString());

        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        } catch (IOException ignored) {
            //TODO... Log here
        }

    }
}
