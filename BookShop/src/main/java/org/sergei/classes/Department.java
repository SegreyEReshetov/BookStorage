package org.sergei.classes;


import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Category> categories;

    public Department(String name) {
        this.name = name;
        this.categories = new ArrayList<>();
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Category> getCategories() {
        return categories;
    }
}
