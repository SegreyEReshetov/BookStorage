package org.sergei;
import org.sergei.classes.Book;
import org.sergei.classes.Bookstore;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.sergei.reader.FileReader.readFromFile;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

            Bookstore bookStorage = new Bookstore();

            bookStorage.createBookStoreFromFile(readFromFile(args[0]));
            List<Book> booksByAuthor = bookStorage.searchBooksByAuthor("Автор1");
            log.info("Найденные книги по автору : {}", booksByAuthor.toString());

            List<Book> booksByGenre = bookStorage.searchBooksByGenre("Б");

            log.info("Найденные книги по жанру : {}", booksByGenre.toString());
    }
}
