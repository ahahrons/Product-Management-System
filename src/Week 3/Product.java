public class Product {
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

    public String getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(String dateEntered) {
        this.dateEntered = dateEntered;
    }

    public String getDateExpiry() {
        return dateExpiry;
    }

    public void setDateExpiry(String dateExpiry) {
        this.dateExpiry = dateExpiry;
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