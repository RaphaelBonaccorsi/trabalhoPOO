import java.util.Date;

public class Loan {
    private Book book;
    private Patron patron;
    private Date checkoutDate;
    private Date dueDate;

    public Loan(Book book, Patron patron, Date checkoutDate, Date dueDate) {
        this.book = book;
        this.patron = patron;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
    }

    // Getters e setters
    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
    public Patron getPatron() { return patron; }
    public void setPatron(Patron patron) { this.patron = patron; }
    public Date getCheckoutDate() { return checkoutDate; }
    public void setCheckoutDate(Date checkoutDate) { this.checkoutDate = checkoutDate; }
    public Date getDueDate() { return dueDate; }
    public void setDueDate(Date dueDate) { this.dueDate = dueDate; }
}
