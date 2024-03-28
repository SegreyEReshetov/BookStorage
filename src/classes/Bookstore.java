package classes;

import java.util.ArrayList;
import java.util.List;

public class Bookstore {
    private List<Department> departments;

        public Bookstore() {
        this.departments = new ArrayList<>();
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
}
