package FoodDeliveryApp.Level1;

//3. Program to Handle Book Details
public class Book {
    private String title;
    private String author;
    private double price;

    // Constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

    // Main method to test Book class
    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", "James Gosling", 450.75);
        book1.displayDetails();
    }
}
