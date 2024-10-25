class ElectronicProduct extends Product {
    private String brand;
    private int warrantyPeriod;

    public ElectronicProduct(String productID, String productName, String category, double price, String dateEntered, String dateExpiry, String brand, int warrantyPeriod) {
        super(productID, productName, category, price, dateEntered, dateExpiry);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public String toString() {
        return super.toString() + "Brand: " + brand + "\nWarranty Period: " + warrantyPeriod + " months";
    }
}