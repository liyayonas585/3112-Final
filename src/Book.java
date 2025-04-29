
public class Book {
    public String title;
    public String author;
    public String genre;
    public float price;
    public int quantity;

    public Book(String title, String author, String genre, float price, int quantity) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.quantity = quantity;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }   
    public String getGenre() {
        return genre;
    }
    public float getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setPrice(float price) {
        this.price = price;
    }
}
