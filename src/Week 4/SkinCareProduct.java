public class SkinCareProduct extends Product {
    private double volume;

    public SkinCareProduct(String productID, String productName, String category, double price, String dateEntered, String dateExpiry, double volume) {
        super(productID, productName, category, price, dateEntered, dateExpiry);
        this.volume = volume;
    }

    @Override
    public String toString() {
        return super.toString() + "Volume: " + volume + " ml";
    }
}