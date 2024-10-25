public interface IProductManageable {
    void addProduct(Product product);
    void updateProduct(String oldID, Product updatedProduct);
    void deleteProduct(String id);
    Product viewProduct(String productID);
    void displayAllProducts();
}