package org.sergei;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.sergei.classes.Book;
import org.sergei.classes.Bookstore;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookStoreTest {


    private Bookstore bookstore;
    private List<String> bookStoreInfo;


    @BeforeEach
    public void init() {
        bookstore =  new Bookstore();
        bookStoreInfo = new ArrayList<>();
        bookStoreInfo.add("А;A;Книга1;Автор1;2002;3");
        bookStoreInfo.add("А;В;Книга2;Автор2;2002;3");
        bookStoreInfo.add("А;Б;Книга3;Автор2;2002;3");
        bookStoreInfo.add("А;В;Книга4;Автор3;2002;3");
    }




    @Test
    @Order(1)
    public void testCreateBookStore() {
        bookstore.createBookStoreFromFile(bookStoreInfo);

        assertNotNull(bookstore.getDepartments());
        assertNotEquals(0, bookstore.getDepartments().size());
    }

    @Test
    @Order(2)
    public void testFindByAuthor() {
        bookstore.createBookStoreFromFile(bookStoreInfo);
        List<Book> booksByAuthor = bookstore.searchBooksByAuthor("Автор1");
        assertEquals("Книга1", booksByAuthor.stream().findFirst().get().getTitle());
    }

    @Test
    @Order(3)
    public void testFindByGender() {
        bookstore.createBookStoreFromFile(bookStoreInfo);

        List<Book> booksByGenre = bookstore.searchBooksByGenre("Б");
        assertEquals("Книга3", booksByGenre.stream().findFirst().get().getTitle());
    }


    @Test
    @Order(4)
    public void testNewFunc() {

        Book book = new Book("Book1", "Author1", "Novel", 1987, 5000) ;

        assertEquals("Book1", book.NewFunc());

    }
}
