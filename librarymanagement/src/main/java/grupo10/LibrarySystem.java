package grupo10;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Represents the library system.
 * This class manages books, patrons, and loans.
 */
public class LibrarySystem {
    private List<Book> books;
    private List<Patron> patrons;
    private List<Loan> loans;
    private static final String BOOK_FILE = "book.txt";
    private static final String PATRON_FILE = "patron.txt";
     /**
     * Constructs a new LibrarySystem.
     */
    public LibrarySystem() {
        books = new ArrayList<>();
        patrons = new ArrayList<>();
        loans = new ArrayList<>();
        loadBooksFromFile();
        loadPatronsFromFile();
    }

   /**
     * Adds a book to the library system.
     */
    public void addBook(Book book) {
        books.add(book);
        saveBooksToFile();
    }
    /**
     * remove a book from the library system.
     */
    public void removeBook(Book book) {
        books.remove(book);
        saveBooksToFile();
    }
    /**
     * edite a book of the library system.
     */
    public void editBook(Book oldBook, Book newBook) {
        int index = books.indexOf(oldBook);
        if (index != -1) {
            books.set(index, newBook);
            saveBooksToFile();
        }
    }
    /**
     * search a book in library system.
     * the search can be by: title, author, ISBN, category
     */
    public List<Book> searchBooksByTitle(String title) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                results.add(book);
            }
        }
        return results;
    }

    public List<Book> searchBooksByAuthor(String author) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().contains(author)) {
                results.add(book);
            }
        }
        return results;
    }

    public List<Book> searchBooksByIsbn(String isbn) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getIsbn().contains(isbn)) {
                results.add(book);
            }
        }
        return results;
    }

    public List<Book> searchBooksByCategory(String category) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getCategory().contains(category)) {
                results.add(book);
            }
        }
        return results;
    }

    /**
     * Add patron to the library system.
     */
    public void addPatron(Patron patron) {
        patrons.add(patron);
        savePatronsToFile();
    }
    /**
     * remove patron from the library system.
     */
    public void removePatron(Patron patron) {
        patrons.remove(patron);
        savePatronsToFile();
    }
    /**
     * edite patron of the library system.
     */
    public void editPatron(Patron oldPatron, Patron newPatron) {
        int index = patrons.indexOf(oldPatron);
        if (index != -1) {
            patrons.set(index, newPatron);
            savePatronsToFile();
        }
    }
    /**
     * search a patron in the library system.
     */
    public List<Patron> searchPatrons(String query) {
        List<Patron> results = new ArrayList<>();
        for (Patron patron : patrons) {
            if (patron.getName().contains(query) || 
                patron.getContactInfo().contains(query)) {
                results.add(patron);
            }
        }
        return results;
    }

    public Patron searchPatronByName(String name) {
        for (Patron patron : patrons) {
            if (patron.getName().equals(name)) {
                return patron;
            }
        }
        return null;
    }

    /*
     * manages loans in the library system
     */
    public void checkoutBook(Book book, Patron patron, Date dueDate) {
        loans.add(new Loan(book, patron, new Date(), dueDate));
    }

    public void checkinBook(Book book) {
        loans.removeIf(loan -> loan.getBook().equals(book));
    }

    public List<Loan> getOverdueLoans() {
        List<Loan> overdueLoans = new ArrayList<>();
        Date now = new Date();
        for (Loan loan : loans) {
            if (loan.getDueDate().before(now)) {
                overdueLoans.add(loan);
            }
        }
        return overdueLoans;
    }

    public List<Book> getBooks() {
        return books;
    }

    public boolean isBookCheckedOut(Book book) {
        for (Loan loan : loans) {
            if (loan.getBook().equals(book)) {
                return true;
            }
        }
        return false;
    }

    private void loadBooksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOK_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    Book book = new Book(parts[0], parts[1], parts[2], parts[3]);
                    books.add(book);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading books from file: " + e.getMessage());
        }
    }
    /*
     * save books on file book.txt
     */
    private void saveBooksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOK_FILE))) {
            for (Book book : books) {
                writer.write(book.getTitle() + ";" + book.getAuthor() + ";" + book.getIsbn() + ";" + book.getCategory());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving books to file: " + e.getMessage());
        }
    }

    private void loadPatronsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATRON_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2) {
                    Patron patron = new Patron(parts[0], parts[1]);
                    patrons.add(patron);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading patrons from file: " + e.getMessage());
        }
    }
    /*
     * save patrons on file patron.txt
     */
    private void savePatronsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATRON_FILE))) {
            for (Patron patron : patrons) {
                writer.write(patron.getName() + ";" + patron.getContactInfo());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving patrons to file: " + e.getMessage());
        }
    }
}
