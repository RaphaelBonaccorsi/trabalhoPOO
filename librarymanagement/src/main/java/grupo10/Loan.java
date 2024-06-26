package grupo10;
import java.util.Date;
/**
 * Represents a loan of a book to a patron.
 * A loan has a book, a patron, and a due date.
 */
public class Loan {
    private Book book;
    private Patron patron;
    private Date checkoutDate;
    private Date dueDate;

    /**
     * Constructs a new Loan for the specified book and patron.
     * The due date is set to two weeks from the current date.
     */
    public Loan(Book book, Patron patron, Date checkoutDate, Date dueDate) {
        this.book = book;
        this.patron = patron;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
    }

    /*
     * gets the book associated with this loan
     */
    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
     /*
     * gets the patron associated with this loan
     */
    public Patron getPatron() { return patron; }
    public void setPatron(Patron patron) { this.patron = patron; }
    /*
     * gets the checkout of this loan
     */
    public Date getCheckoutDate() { return checkoutDate; }
    public void setCheckoutDate(Date checkoutDate) { this.checkoutDate = checkoutDate; }
    /*
     * gets the due date of this loan
     */
    public Date getDueDate() { return dueDate; }
    public void setDueDate(Date dueDate) { this.dueDate = dueDate; }
}
