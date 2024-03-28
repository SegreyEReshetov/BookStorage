import java.util.List;

import classes.*;

/**
 * Необходимо создать программу на Java для управления книжным магазином. 
 * В магазине имеется несколько отделов, каждый отдел содержит различные категории книг, 
 * а каждая категория содержит список конкретных книг. 
 * Каждая книга имеет название, автора, жанр, год издания и цену. 
 * Необходимо реализовать функционал для добавления новых книг, 
 * поиска книг по различным параметрам (например, по автору или жанру)
 */
public class Main {
    public static void main(String[] args) {
            
        Bookstore bookstore = new Bookstore();

        Department fictionDepartment = new Department("Fiction");
        Category novelCategory = new Category("Novels");
        Book book = new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 1960, 12.99);
        novelCategory.addBook(book);
        fictionDepartment.addCategory(novelCategory);
        bookstore.addDepartment(fictionDepartment);

        // Пример использования функционала:
        // Поиск книг по автору
        List<Book> booksByAuthor = bookstore.searchBooksByAuthor("Harper Lee");

        // Поиск книг по жанру
        List<Book> booksByGenre = bookstore.searchBooksByGenre("Fiction");
    }
}