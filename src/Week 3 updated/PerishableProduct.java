public class PerishableProduct extends Product {
    private String storageInstructions;

    public PerishableProduct(int productID, String productName, String category, double price, String dateEntered, String dateExpiry, String storageInstructions) {
        super(productName, productName, category, price, dateEntered, dateExpiry);
        this.storageInstructions = storageInstructions;
    }


    public String getStorageInstructions() {
        return storageInstructions;
    }

    public void setStorageInstructions(String storageInstructions) {
        this.storageInstructions = storageInstructions;
    }

    @Override
    public String toString() {
        return super.toString() + "Storage Instructions: " + storageInstructions;
    }
}