import java.util.ArrayList;
import java.util.List;
public class Bookstore{
    private String location;
    private String name; 
    private List<Book> inventory;
    private List<Sales> salesLog;
    private float dailyRevenue;

    public Bookstore(String location, String name) {
        this.location = location;
        this.name = name;
        this.inventory = new ArrayList<>();
        this.salesLog = new ArrayList<>();
        this.dailyRevenue = 0.0f;
    }

    public List<Book> getInventory() {
        return inventory;
    }

    public List<Sales> getSalesLog() {
        return salesLog;
    }

    public void sellBook(Book book, int quantity, String date) {
        if (inventory.contains(book) && book.getQuantity() >= quantity) {
            book.setQuantity(book.getQuantity() - quantity);
            float totalSale = book.getPrice() * quantity;
            dailyRevenue += totalSale;
            salesLog.add(new Sales(date, book.getTitle(), quantity, totalSale));
            System.out.println("Sold " + quantity + " copies of " + book.getTitle());
            if (book.getQuantity() == 0) {
                System.out.println("Book " + book.getTitle() + " is now sold out and removed from inventory.");
            }
        } else {
            System.out.println("Not enough copies available for sale.");
        }
    }
    public float getDailyRevenue() {
        return dailyRevenue;
    }

    public void viewSalesLog() {
        if (salesLog.isEmpty()) {
            System.out.println("No sales recorded yet.");
        } else {
            for (Sales sale : salesLog) {
                System.out.println("Date: " + sale.getDateSold() + ", Book: " + sale.getBook() + ", Quantity: " + sale.getQuantity() + ", Total Price: " + sale.getTotalPrice());
            }
        }
    }
}
