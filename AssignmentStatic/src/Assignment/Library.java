package Assignment;

class Book{
private static String libraryName;
	
	private String title;
	private String author;
	private final String isbn;
	
	public Book(String title , String author , String isbn) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		
	}
	
	public static void setLibraryName(String name) {
		libraryName = name;
	}

	public static void displayLIbraryName() {
		System.out.println("Library Name : " + libraryName);
	}
	
	 public void displayBookDetails() {
	       // Using 'instanceof' to verify the object's type before displaying details
		 
	       if (this instanceof Book) {
	           System.out.println("Title: " + title);
	           System.out.println("Author: " + author);
	           System.out.println("ISBN: " + isbn);
	       } else {
	           System.out.println("The object is not an instance of the Book class.");
	       }
	   }
	 
	 public String getTitle(String title) {
		 return title;
	 }
	 
	 public String getAuthor(String author) {
		 return author;
	 }
	 
	 public String getIsbn(String isbn) {
		 return isbn;
	 }
	
}

public class Library {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book.setLibraryName("Think Point");
		
		Book.displayLIbraryName();
		
		  Book book1 = new Book("Effective Java", "Joshua Bloch", "978-0134685991");
	       // Display book details
	       book1.displayBookDetails();
	}

}
