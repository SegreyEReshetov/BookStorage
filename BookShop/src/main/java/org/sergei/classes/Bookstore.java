package org.sergei.classes;


import org.sergei.classes.enumuration.OrderStatus;

import java.util.ArrayList;
import java.util.List;
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


    public Bookstore createBookStoreFromFile(List<String> bookInfo) {
        for (String info : bookInfo) {
            
            String[] departmentAndCategoryAndBook = info.split(";");
            Department dep = findDeparment(departmentAndCategoryAndBook[0]);
            if (dep == null) {
                dep = new Department(departmentAndCategoryAndBook[0]);
                departments.add(dep);
            }

            Category category = findCategoryInDep(dep.getCategories(), departmentAndCategoryAndBook[1]);
            if (category == null) {
                category = new Category(departmentAndCategoryAndBook[1]);
                dep.addCategory(category);
            }

            category.addBook(new Book(departmentAndCategoryAndBook[2], departmentAndCategoryAndBook[3],
                    departmentAndCategoryAndBook[1], Integer.parseInt(departmentAndCategoryAndBook[4]),
                    Double.parseDouble(departmentAndCategoryAndBook[5])));

        }
    
        return this;
    }

    private Category findCategoryInDep(List<Category> categories, String s) {
        for (Category category : categories) {
            if (category.getName().equals(s)) {
                return category;
            }
        }
        return null;
    }

    private Department findDeparment(String s) {

        for (Department dep : departments) {
            if (dep.getName().equals(s)) {
                return dep;
            }
        }
        return null;
    }

    private static void addOrder(Bookstore bookstore) {
        Order order = new Order();

        Book book1 = new Book("МетодичкаА", "Решетов Сергей", "Fiction", 2023, 3);

        Book book2 = new Book("МетодичкаB", "Решетов Сергей", "Fiction", 2022, 4);

        order.addBook(book1);
        order.addBook(book2);

        Order orderResult = bookstore.checkOrder(order);
    }

    public List<Book> searchBooksByAuthor(String author) {

        List<Book> result = new ArrayList<>();

        for (Department department : departments) {
            for (Category category : department.getCategories()) {
                for (Book book : category.getBooks()) {
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

        for (Department department : departments) {
            for (Category category : department.getCategories()) {
                for (Book book : category.getBooks()) {
                    if (book.getGenre().equals(genre)) {
                        result.add(book);
                    }
                }
            }
        }

        return result;
    }

    private boolean ifHasBook(Book bookToSearch) { 
        for (Department department : departments) {
            for (Category category : department.getCategories()) {
                for (Book book : category.getBooks()) {
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

    public List<Department> getDepartments() {
        return departments;
    }
}
