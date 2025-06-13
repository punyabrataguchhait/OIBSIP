import java.util.*;

public class LibrarySystem {
    List<Book> books = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    String adminUsername = "admin";
    String adminPassword = "lib123";

    public void seedData() {
        books.add(new Book(1, "Clean Code", "Robert C. Martin"));
        books.add(new Book(2, "Java: The Complete Reference", "Herbert Schildt"));
        books.add(new Book(3, "Effective Java", "Joshua Bloch"));
    }

    public void adminMenu() {
        System.out.print("Enter admin username: ");
        String user = sc.next();
        System.out.print("Enter admin password: ");
        String pass = sc.next();

        if (user.equals(adminUsername) && pass.equals(adminPassword)) {
            int choice;
            do {
                System.out.println("\nAdmin Menu");
                System.out.println("1. Add Book");
                System.out.println("2. Delete Book");
                System.out.println("3. View All Books");
                System.out.println("4. Back");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1: addBook(); break;
                    case 2: deleteBook(); break;
                    case 3: viewBooks(); break;
                }
            } while (choice != 4);
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    public void addBook() {
        System.out.print("Enter book ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        System.out.print("Enter author: ");
        String author = sc.nextLine();
        books.add(new Book(id, title, author));
        System.out.println("Book added successfully.");
    }

    public void deleteBook() {
        System.out.print("Enter book ID to delete: ");
        int id = sc.nextInt();
        books.removeIf(book -> book.id == id);
        System.out.println("Book deleted (if existed).");
    }

    public void userMenu() {
        int choice;
        do {
            System.out.println("\nUser Menu");
            System.out.println("1. View Books");
            System.out.println("2. Search Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Back");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: viewBooks(); break;
                case 2: searchBook(); break;
                case 3: issueBook(); break;
                case 4: returnBook(); break;
            }
        } while (choice != 5);
    }

    public void viewBooks() {
        System.out.println("\nAll Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void searchBook() {
        sc.nextLine();
        System.out.print("Enter title or author to search: ");
        String query = sc.nextLine().toLowerCase();
        for (Book book : books) {
            if (book.title.toLowerCase().contains(query) || book.author.toLowerCase().contains(query)) {
                System.out.println(book);
            }
        }
    }

    public void issueBook() {
        System.out.print("Enter book ID to issue: ");
        int id = sc.nextInt();
        for (Book book : books) {
            if (book.id == id && !book.issued) {
                book.issued = true;
                System.out.println("Book issued successfully.");
                return;
            }
        }
        System.out.println("Book not found or already issued.");
    }

    public void returnBook() {
        System.out.print("Enter book ID to return: ");
        int id = sc.nextInt();
        for (Book book : books) {
            if (book.id == id && book.issued) {
                book.issued = false;
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Book not found or wasn't issued.");
    }
}