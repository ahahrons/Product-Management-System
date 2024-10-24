// Product Management System
// Group Number 12
// Binuya, Licup, Pascual, Yulianto
// CYB - 201
public class SkincareProduct extends Product implements Volumetric {
    private double volume;
    private static final double MIN_VOLUME = 0;
    private static final double MAX_VOLUME = 1000;

    public SkincareProduct(String productID, String productName, String category,double price, String dateEntered, String dateExpiry, double volume) {
        super(productID, productName, category, price, dateEntered, dateExpiry);
        this.volume = volume;
    }

    @Override
    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public double getVolume() {
        return volume;
    }

    @Override
    public boolean checkVolumeLimits() {
        return volume > MIN_VOLUME && volume <= MAX_VOLUME;
    }

    @Override
    public String getProductDetails() {
        return toString() + "\nVolume: " + volume + "ml";
    }

    @Override
    public void validateProduct() {
        if (!checkVolumeLimits()) {
            throw new IllegalStateException("Volume must be between " + MIN_VOLUME + " and " + MAX_VOLUME + "ml");
        }
    }
}