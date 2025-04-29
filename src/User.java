public abstract class User {
    private String name;
    private int userID;
    private String job;

    public User(String name, String userID2, String job) {
        this.name = name;
        this.userID = userID;
        this.job = job;
    }

    public void login() {
        System.out.println(name + " has logged in successfully.");
    }       

    public void logout() {
        System.out.println(name + " has logged out successfully.");
    }
    // Method to search for a book by title and author
    // Returns true if the book is found, false otherwise
    public boolean searchBook(Bookstore store, String title) {
        for (Book book : store.getInventory()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book.getTitle() + " by " + book.getAuthor());
                return true;
            }
        }
        System.out.println("Book not found.");
        return false; 
    }
    // Method to add a new book to the store's inventory
    public void addBook(Bookstore store, Book book) {
        store.getInventory().add(book);
        System.out.println("Book added: " + book.getTitle() + " by " + book.getAuthor());
    }


    // Method to request more copies of a book to inventory
    public void requestBook(Bookstore store, Book book, int quantity) {
        System.out.println(name + " requested " + quantity + " copies of: " + book.getTitle());
    }


}