class ClothingProduct extends Product {
    private String size;
    private String color;

    public ClothingProduct(String productID, String productName, String category, double price, String dateEntered, String dateExpiry, String size, String color) {
        super(productID, productName, category, price, dateEntered, dateExpiry);
        this.size = size;
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + "Size: " + size + "\nColor: " + color;
    }
}