public class Sales {
    private String dateSold; 
    private String book; 
    private int quantity;
    private float totalPrice;

    public Sales(String dateSold, String book, int quantity, float totalPrice) {
        this.dateSold = dateSold;
        this.book = book;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
    public float getTotalPrice() { return totalPrice; }
    public String getDateSold() { return dateSold; }
    public String getBook() { return book; }
    public int getQuantity() { return quantity;}
}
