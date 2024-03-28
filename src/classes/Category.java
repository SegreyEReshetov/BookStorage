package classes;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<Book> books;

    public Category(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
       this.books.add(book);
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public List<Book> getBooks() {
        return books;
    }

}
