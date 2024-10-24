// Product Management System
// Group Number 12
// Binuya, Licup, Pascual, Yulianto
// CYB - 201
public class PerishableProduct extends Product implements StorageManageable {
    private String storageInstructions;

    public PerishableProduct(String productID, String productName, String category, double price, String dateEntered, String dateExpiry, String storageInstructions) {
        super(productID, productName, category, price, dateEntered, dateExpiry);
        this.storageInstructions = storageInstructions;
    }

    @Override
    public void setStorageInstructions(String instructions) {
        this.storageInstructions = instructions;
    }

    @Override
    public String getStorageInstructions() {
        return storageInstructions;
    }

    @Override
    public String getProductDetails() {
        return toString() + "\nStorage Instructions: " + storageInstructions;
    }

    @Override
    public void validateProduct() {
        if (storageInstructions == null || storageInstructions.trim().isEmpty()) {
            throw new IllegalStateException("Storage instructions cannot be empty for perishable products");
        }
    }
}