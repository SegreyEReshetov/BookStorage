package org.sergei.classes;

import org.sergei.classes.enumuration.OrderStatus;

import java.util.ArrayList;
import java.util.List;


public class Order {
    private List<Book> books;
    private OrderStatus status;

    public Order() {
        this.books = new ArrayList<>();
        this.status = OrderStatus.IN_PROGRESS;
    }


    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public OrderStatus getStatus() {
        return status;
    }
    
    public List<Book> getBooks() {
        return books;
    }

}
