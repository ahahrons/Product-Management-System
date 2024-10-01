import java.time.LocalDate;

public class Product {
    private String productID;
    private String productName;
    private String category;
    private double price;
    private LocalDate dateEntered;
    private LocalDate dateExpiry;

    public Product(String productID, String productName, String category, double price, LocalDate dateEntered, LocalDate dateExpiry) {
        this.productID = productID;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.dateEntered = dateEntered;
        this.dateExpiry = dateExpiry;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(LocalDate dateEntered) {
        this.dateEntered = dateEntered;
    }

    public LocalDate getDateExpiry() {
        return dateExpiry;
    }

    public void setDateExpiry(LocalDate dateExpiry) {
        this.dateExpiry = dateExpiry;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", dateEntered=" + dateEntered +
                ", dateExpiry=" + dateExpiry +
                '}';
    }
}