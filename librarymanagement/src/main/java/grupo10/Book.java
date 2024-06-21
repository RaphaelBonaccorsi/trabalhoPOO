/**
 * Represents a book in the library system.
 * A book has a title, author, ISBN, and availability status.
 */
public class Book {
    private String title;
    private String author;
    private String isbn;
    private String category;

    /**
     * Constructs a new Book with the specified title, author, and ISBN.
     * The book is initially available.
     */
    public Book(String title, String author, String isbn, String category) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = category;
    }

    // Getters e setters
    /**
     * Gets the title of the book.
     */
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

     /**
     * Gets the author of the book.
     */
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    /**
     * Gets the ISBN of the book.
     */
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    /**
     * Gets the Category of the book.
     */
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
