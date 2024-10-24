// Product Management System
// Group Number 12
// Binuya, Licup, Pascual, Yulianto
// CYB - 201
public abstract class Product {
    private String productID;
    private String productName;
    private String category;
    private double price;
    private String dateEntered;
    private String dateExpiry;

    public Product(String productID, String productName, String category, double price, String dateEntered, String dateExpiry) {
        this.productID = productID;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.dateEntered = dateEntered;
        this.dateExpiry = dateExpiry;
    }

    public abstract String getProductDetails();
    public abstract void validateProduct();

    public String getProductID() {
        return productID;
    }

    @Override
    public String toString() {
        return String.format("""
                Product:
                Product ID: %s
                Product Name: %s
                Product Category: %s
                Product Price: $%.2f
                Date Entered: %s
                Date Expiry: %s
                """,
                productID, productName, category, price, dateEntered, dateExpiry);
    }
}