// Product Management System
// Group Number 12
// Binuya, Licup, Pascual, Yulianto
// CYB - 201
public class ElectronicProduct extends Product implements Warrantable {
    private String brand;
    private int warrantyPeriod;

    public ElectronicProduct(String productID, String productName, String category,double price, String dateEntered, String dateExpiry,String brand, int warrantyPeriod) {
        super(productID, productName, category, price, dateEntered, dateExpiry);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public void setWarrantyPeriod(int months) {
        this.warrantyPeriod = months;
    }

    @Override
    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    @Override
    public String getProductDetails() {
        return toString() + "\nBrand: " + brand + "\nWarranty Period: " + warrantyPeriod + " months";
    }

    @Override
    public void validateProduct() {
        if (warrantyPeriod <= 0) {
            throw new IllegalStateException("Warranty period must be greater than 0");
        }
    }
}