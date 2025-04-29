import java.util.Scanner;
import java.time.LocalDate;

public class Main{
public static void main(String[] args) {
    // Create a scanner for user input
    Scanner scanner = new Scanner(System.in);
    // Create a bookstore instance
    Bookstore store = new Bookstore("875 Main St", "Books a Million");
    
    // Create an employee and an owner
    Employee employee = new Employee("Chloe", "E001", "Sales Associate", 201);
    Owner owner = new Owner("John", "O001", "Owner", 101);
    
    System.out.println("Welcome to the Bookstore Management System!");
    System.out.println("Select user type: \n1. Owner \n2. Employee");
    int id = scanner.nextInt();
    scanner.nextLine();

    User currentUser;
    if (id == 1) {
        currentUser = owner;
    } else if (id == 2) {
        currentUser = employee;
    } else {
        System.out.println("Invalid user ID. Exiting.");
        scanner.close();
        return;
    }

    currentUser.login(); // Login the user  
    boolean running = true;
    while (running) {
        System.out.println("Select an action: \n1. Add Book  \n2. Search Book \n3. Request Book \n4. Sell a Book \n5. Logout");
        if (currentUser instanceof Owner) {
            System.out.println("6. View Total Revenue");
        }
        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                // Add a book
                System.out.println("Enter book title: ");
                String title = scanner.nextLine();
                System.out.println("Enter book author: ");
                String author = scanner.nextLine();
                System.out.println("Enter book genre: ");
                String genre = scanner.nextLine();
                System.out.println("Enter book price: ");
                float price = scanner.nextFloat();
                System.out.println("Enter stock quantity: ");
                int quantity = scanner.nextInt();
                Book newBook = new Book(title, author, genre, price, quantity);
                currentUser.addBook(store, newBook);
                break;
            case 2:
                // Search for a book
                System.out.println("Enter book title to search: ");
                String searchTitle = scanner.nextLine();
                currentUser.searchBook(store, searchTitle);
                break;
            case 3:
                // Request more copies of a book
                System.out.println("Enter book title to request: ");
                String requestTitle = scanner.nextLine();
                System.out.println("Enter quantity to request: ");
                int requestQuantity = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                Book requestedBook = new Book(requestTitle, "Unknown", "Unknown", 0.0f, requestQuantity);
                currentUser.requestBook(store, requestedBook, requestQuantity);
            
                break;
            case 4:
                // Sell a book
                System.out.println("Enter book title to sell: ");
                String sellTitle = scanner.nextLine();
                System.out.println("Enter quantity to sell: ");
                int sellQuantity = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                Book bookToSell = null;
                for (Book book : store.getInventory()) {
                    if (book.getTitle().equalsIgnoreCase(sellTitle)) {
                        bookToSell = book;
                        break;
                    } 
                }
                if (bookToSell != null) {
                    String today = LocalDate.now().toString();
                    store.sellBook(bookToSell, sellQuantity, today);
                } else {
                    System.out.println("Book not found in inventory.");
                }
                break;
            case 5:
                // Logout
                currentUser.logout();
                running = false; // Exit the loop
                break;
            default:
                System.out.println("Invalid action. Please try again.");
                
            case 6:
                // View total revenue (only for owner)
                if (currentUser instanceof Owner) {
                    float totalRevenue = ((Owner) currentUser).viewTotalRevenue(store);
                    System.out.println("Total Revenue: $" + totalRevenue);
                } else {
                    System.out.println("Only the owner can view total revenue.");
                }
                break;
        }
    }
    // Close the scanner
    scanner.close();
}
}