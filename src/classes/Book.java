package classes;

public class Book {

    private String title;
    private String author;
    private String genre;
    private int year;
    private double price;

    public Book(String title, String author, String genre, int year, double price) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.price = price;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    
    public String getAuthor() {
        return author;
    }


    public void setAuthor(String author) {
        this.author = author;
    }


    
    public String getGenre() {
        return genre;
    }


    public void setGenre(String genre) {
        this.genre = genre;
    }

    
    public int getYear() {
        return year;
    }


    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }



}