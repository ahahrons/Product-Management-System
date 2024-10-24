// Product Management System
// Group Number 12
// Binuya, Licup, Pascual, Yulianto
// CYB - 201
public class ClothingProduct extends Product implements Sizeable {
    private String size;
    private String color;

    public ClothingProduct(String productID, String productName, String category,double price, String dateEntered, String dateExpiry, String size, String color) {
        super(productID, productName, category, price, dateEntered, dateExpiry);
        this.size = size;
        this.color = color;
    }

    @Override
    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String getSize() {
        return size;
    }

    @Override
    public String getProductDetails() {
        return toString() + "\nSize: " + size + "\nColor: " + color;
    }

    @Override
    public void validateProduct() {
        if (!size.matches("(?i)(Small|Medium|Large|XL|XXL)")) {
            throw new IllegalStateException("Invalid size specification");
        }
    }
}