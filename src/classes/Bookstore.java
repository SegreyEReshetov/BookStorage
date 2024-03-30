package classes;

import java.util.ArrayList;
import java.util.List;

import classes.enumuration.OrderStatus;

public class Bookstore {
    private List<Department> departments;
    private List<Order> orders;

    public Bookstore() {
        this.departments = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public List<Book> searchBooksByAuthor(String author) {

        List<Book> result = new ArrayList<>();

        for (var department : departments) {
            for (var category : department.getCategories()) {
                for (var book : category.getBooks()) {
                    if (book.getAuthor().equals(author)) {
                        result.add(book);
                    }
                }
            }
        }

        return result;
    }

    public List<Book> searchBooksByGenre(String genre) {

        List<Book> result = new ArrayList<>();

        for (var department : departments) {
            for (var category : department.getCategories()) {
                for (var book : category.getBooks()) {
                    if (book.getGenre().equals(genre)) {
                        result.add(book);
                    }
                }
            }
        }

        return result;
    }

    private boolean ifHasBook(Book bookToSearch) { 
        for (var department : departments) {
            for (var category : department.getCategories()) {
                for (var book : category.getBooks()) {
                    if (book.equals(bookToSearch)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Order checkOrder(Order order) {
       int countOfBook = 0;
        Order result = new Order();
       for (Book book : order.getBooks()) {
          if (ifHasBook(book)) {
            result.addBook(book);
            countOfBook++;
          }
       }
       if (countOfBook == order.getBooks().size()) {
            result.setStatus(OrderStatus.COMPLETE);
       } else {
            result.setStatus(OrderStatus.NOT_FULL);
       }
       return result;
    }


}
