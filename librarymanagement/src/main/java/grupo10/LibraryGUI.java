import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

public class LibraryGUI extends JFrame {
    private LibrarySystem librarySystem;
    private UserAuthentication userAuth;
    private static boolean running = true; // Variável para verificar se a janela está aberta

    public LibraryGUI() {
        librarySystem = new LibrarySystem();
        userAuth = new UserAuthentication();
        
        setTitle("Library Management System");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        showLoginInterface();

        // Adiciona um listener para fechar a aplicação quando a janela for fechada
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                running = false; // Define running como false quando a janela for fechada
            }
        });
    }

    public static boolean isRunning() {
        return running;
    }

    private void showLoginInterface() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Library Management System", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 10, 20, 10);
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel userLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(userLabel, gbc);

        JTextField userField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(userField, gbc);

        JLabel passLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(passLabel, gbc);

        JPasswordField passField = new JPasswordField();
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(passField, gbc);

        JButton loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(loginButton, gbc);

        JButton registerButton = new JButton("Register");
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(registerButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());
                if (username.isEmpty() || password.isEmpty()) {
                    showMessage("Error", "Username and password cannot be empty.");
                } else if (userAuth.authenticate(username, password)) {
                    showLibraryInterface();
                } else {
                    showMessage("Login Failed", "Invalid username or password.");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());
                if (username.isEmpty() || password.isEmpty()) {
                    showMessage("Error", "Username and password cannot be empty.");
                } else {
                    userAuth.addUser(username, password);
                    showMessage("Registration Success", "User registered successfully.");
                }
            }
        });

        getContentPane().removeAll();
        getContentPane().add(panel);
        revalidate();
        repaint();
    }

    private void showLibraryInterface() {
        JPanel panel = new JPanel(new BorderLayout());

        // Criar o painel de botões com GridBagLayout para ocupar toda a largura do JFrame
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.weightx = 1.0;

        JLabel welcomeLabel = new JLabel("Library System", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridwidth = 2;
        gbc.gridy = 0;
        buttonPanel.add(welcomeLabel, gbc);

        JButton addBookButton = new JButton("Add Book");
        gbc.gridy++;
        buttonPanel.add(addBookButton, gbc);
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });

        JButton editBookButton = new JButton("Edit Book");
        gbc.gridy++;
        buttonPanel.add(editBookButton, gbc);
        editBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editBook();
            }
        });

        JButton removeBookButton = new JButton("Remove Book");
        gbc.gridy++;
        buttonPanel.add(removeBookButton, gbc);
        removeBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeBook();
            }
        });

        JButton searchBookButton = new JButton("Search Book");
        gbc.gridy++;
        buttonPanel.add(searchBookButton, gbc);
        searchBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBook();
            }
        });

        JButton checkoutButton = new JButton("Checkout Book");
        gbc.gridy++;
        buttonPanel.add(checkoutButton, gbc);
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkoutBook();
            }
        });

        JButton checkinButton = new JButton("Checkin Book");
        gbc.gridy++;
        buttonPanel.add(checkinButton, gbc);
        checkinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkinBook();
            }
        });

        JButton addPatronButton = new JButton("Add Patron");
        gbc.gridy++;
        buttonPanel.add(addPatronButton, gbc);
        addPatronButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPatron();
            }
        });

        JButton editPatronButton = new JButton("Edit Patron");
        gbc.gridy++;
        buttonPanel.add(editPatronButton, gbc);
        editPatronButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editPatron();
            }
        });

        JButton removePatronButton = new JButton("Remove Patron");
        gbc.gridy++;
        buttonPanel.add(removePatronButton, gbc);
        removePatronButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removePatron();
            }
        });

        JButton searchPatronButton = new JButton("Search Patron");
        gbc.gridy++;
        buttonPanel.add(searchPatronButton, gbc);
        searchPatronButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchPatron();
            }
        });

        JButton listBooksButton = new JButton("List Books");
        gbc.gridy++;
        buttonPanel.add(listBooksButton, gbc);
        listBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listBooks();
            }
        });

        // Adicionar o texto e a imagem ao lado dos botões
        JPanel infoPanel = new JPanel(new BorderLayout());
        JTextArea infoArea = new JTextArea(
            "Through this system it is possible:\n" +
            "manage the inflow and outflow of books.\n" +
            "check the status of a book.\n" +
            "edit a book.\n" +
            "add, edit and remove a reader."
        );
        infoArea.setWrapStyleWord(true);
        infoArea.setLineWrap(true);
        infoArea.setOpaque(false);
        infoArea.setEditable(false);
        infoArea.setFocusable(false);
        infoPanel.add(infoArea, BorderLayout.NORTH);

        // Adicionar imagem
        ImageIcon imageIcon = new ImageIcon("image.png");
        JLabel imageLabel = new JLabel(imageIcon);
        infoPanel.add(imageLabel, BorderLayout.CENTER);

        // Adicionar painel de rodapé
        JLabel footerLabel = new JLabel("Made by: Diogo, Raphael, Luiz", JLabel.CENTER);
        infoPanel.add(footerLabel, BorderLayout.SOUTH);

        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(infoPanel, BorderLayout.EAST);

        getContentPane().removeAll();
        getContentPane().add(panel);
        revalidate();
        repaint();
    }

    private void addBook() {
        String title = JOptionPane.showInputDialog(this, "Enter Book Title:");
        String author = JOptionPane.showInputDialog(this, "Enter Book Author:");
        String isbn = JOptionPane.showInputDialog(this, "Enter Book ISBN:");
        String category = JOptionPane.showInputDialog(this, "Enter Book Category:");
        if (title.isEmpty() || author.isEmpty() || isbn.isEmpty() || category.isEmpty()) {
            showMessage("Error", "All fields must be filled out.");
        } else {
            Book book = new Book(title, author, isbn, category);
            librarySystem.addBook(book);
            showMessage("Success", "Book added successfully.");
        }
    }

    private void editBook() {
        String isbn = JOptionPane.showInputDialog(this, "Enter Book ISBN to edit:");
        List<Book> books = librarySystem.searchBooksByIsbn(isbn);
        if (!books.isEmpty()) {
            Book oldBook = books.get(0);
            String title = JOptionPane.showInputDialog(this, "Enter new Book Title:", oldBook.getTitle());
            String author = JOptionPane.showInputDialog(this, "Enter new Book Author:", oldBook.getAuthor());
            String newIsbn = JOptionPane.showInputDialog(this, "Enter new Book ISBN:", oldBook.getIsbn());
            String category = JOptionPane.showInputDialog(this, "Enter new Book Category:", oldBook.getCategory());
            if (title.isEmpty() || author.isEmpty() || newIsbn.isEmpty() || category.isEmpty()) {
                showMessage("Error", "All fields must be filled out.");
            } else {
                Book newBook = new Book(title, author, newIsbn, category);
                librarySystem.editBook(oldBook, newBook);
                showMessage("Success", "Book edited successfully.");
            }
        } else {
            showMessage("Error", "Book not found.");
        }
    }

    private void removeBook() {
        String isbn = JOptionPane.showInputDialog(this, "Enter Book ISBN to remove:");
        if (isbn.isEmpty()) {
            showMessage("Error", "ISBN cannot be empty.");
        } else {
            List<Book> books = librarySystem.searchBooksByIsbn(isbn);
            if (!books.isEmpty()) {
                Book book = books.get(0);
                librarySystem.removeBook(book);
                showMessage("Success", "Book removed successfully.");
            } else {
                showMessage("Error", "Book not found.");
            }
        }
    }

    private void searchBook() {
        String[] options = {"Title", "Author", "ISBN", "Category"};
        String criteria = (String) JOptionPane.showInputDialog(this, "Select search criteria:", "Search Book", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (criteria != null) {
            String query = JOptionPane.showInputDialog(this, "Enter search query:");
            if (query.isEmpty()) {
                showMessage("Error", "Search query cannot be empty.");
            } else {
                List<Book> books;
                switch (criteria) {
                    case "Title":
                        books = librarySystem.searchBooksByTitle(query);
                        break;
                    case "Author":
                        books = librarySystem.searchBooksByAuthor(query);
                        break;
                    case "ISBN":
                        books = librarySystem.searchBooksByIsbn(query);
                        break;
                    case "Category":
                        books = librarySystem.searchBooksByCategory(query);
                        break;
                    default:
                        books = null;
                        break;
                }
                if (books != null && !books.isEmpty()) {
                    StringBuilder message = new StringBuilder();
                    for (Book book : books) {
                        message.append("Title: ").append(book.getTitle())
                               .append(", Author: ").append(book.getAuthor())
                               .append(", ISBN: ").append(book.getIsbn())
                               .append(", Category: ").append(book.getCategory())
                               .append(", Reserved: ").append(librarySystem.isBookCheckedOut(book) ? "Yes" : "No")
                               .append("\n");
                    }
                    showMessage("Search Results", message.toString());
                } else {
                    showMessage("Search Results", "No books found.");
                }
            }
        }
    }

    private void checkoutBook() {
        String isbn = JOptionPane.showInputDialog(this, "Enter Book ISBN to checkout:");
        if (isbn.isEmpty()) {
            showMessage("Error", "ISBN cannot be empty.");
        } else {
            List<Book> books = librarySystem.searchBooksByIsbn(isbn);
            if (!books.isEmpty()) {
                Book book = books.get(0);
                String patronName = JOptionPane.showInputDialog(this, "Enter Patron Name:");
                if (patronName.isEmpty()) {
                    showMessage("Error", "Patron name cannot be empty.");
                } else {
                    Patron patron = librarySystem.searchPatronByName(patronName);
                    if (patron != null) {
                        Date dueDate = new Date(); // Simplesmente colocando a data atual como data de devolução
                        librarySystem.checkoutBook(book, patron, dueDate);
                        showMessage("Success", "Book checked out successfully.");
                    } else {
                        showMessage("Error", "Patron not found.");
                    }
                }
            } else {
                showMessage("Error", "Book not found.");
            }
        }
    }

    private void checkinBook() {
        String isbn = JOptionPane.showInputDialog(this, "Enter Book ISBN to checkin:");
        if (isbn.isEmpty()) {
            showMessage("Error", "ISBN cannot be empty.");
        } else {
            List<Book> books = librarySystem.searchBooksByIsbn(isbn);
            if (!books.isEmpty()) {
                Book book = books.get(0);
                librarySystem.checkinBook(book);
                showMessage("Success", "Book checked in successfully.");
            } else {
                showMessage("Error", "Book not found.");
            }
        }
    }

    private void addPatron() {
        String name = JOptionPane.showInputDialog(this, "Enter Patron Name:");
        String contactInfo = JOptionPane.showInputDialog(this, "Enter Patron Contact Info:");
        if (name.isEmpty() || contactInfo.isEmpty()) {
            showMessage("Error", "Name and contact info cannot be empty.");
        } else {
            Patron patron = new Patron(name, contactInfo);
            librarySystem.addPatron(patron);
            showMessage("Success", "Patron added successfully.");
        }
    }

    private void editPatron() {
        String name = JOptionPane.showInputDialog(this, "Enter Patron Name to edit:");
        if (name.isEmpty()) {
            showMessage("Error", "Name cannot be empty.");
        } else {
            Patron oldPatron = librarySystem.searchPatronByName(name);
            if (oldPatron != null) {
                String newName = JOptionPane.showInputDialog(this, "Enter new Patron Name:", oldPatron.getName());
                String contactInfo = JOptionPane.showInputDialog(this, "Enter new Patron Contact Info:", oldPatron.getContactInfo());
                if (newName.isEmpty() || contactInfo.isEmpty()) {
                    showMessage("Error", "All fields must be filled out.");
                } else {
                    Patron newPatron = new Patron(newName, contactInfo);
                    librarySystem.editPatron(oldPatron, newPatron);
                    showMessage("Success", "Patron edited successfully.");
                }
            } else {
                showMessage("Error", "Patron not found.");
            }
        }
    }

    private void removePatron() {
        String name = JOptionPane.showInputDialog(this, "Enter Patron Name to remove:");
        if (name.isEmpty()) {
            showMessage("Error", "Name cannot be empty.");
        } else {
            Patron patron = librarySystem.searchPatronByName(name);
            if (patron != null) {
                librarySystem.removePatron(patron);
                showMessage("Success", "Patron removed successfully.");
            } else {
                showMessage("Error", "Patron not found.");
            }
        }
    }

    private void searchPatron() {
        String query = JOptionPane.showInputDialog(this, "Enter search query (Name, Contact Info):");
        if (query.isEmpty()) {
            showMessage("Error", "Search query cannot be empty.");
        } else {
            List<Patron> patrons = librarySystem.searchPatrons(query);
            StringBuilder message = new StringBuilder();
            for (Patron patron : patrons) {
                message.append("Name: ").append(patron.getName())
                       .append(", Contact Info: ").append(patron.getContactInfo())
                       .append("\n");
            }
            showMessage("Search Results", message.toString());
        }
    }

    private void listBooks() {
        List<Book> books = librarySystem.getBooks();
        StringBuilder message = new StringBuilder();
        for (Book book : books) {
            message.append("Title: ").append(book.getTitle())
                   .append(", Author: ").append(book.getAuthor())
                   .append(", ISBN: ").append(book.getIsbn())
                   .append(", Category: ").append(book.getCategory())
                   .append(", Reserved: ").append(librarySystem.isBookCheckedOut(book) ? "Yes" : "No")
                   .append("\n");
        }
        showMessage("List of Books", message.toString());
    }

    private void showMessage(String title, String message) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
