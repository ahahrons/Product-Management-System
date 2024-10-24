// Product Management System
// Group Number 12
// Binuya, Licup, Pascual, Yulianto
// CYB - 201
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ProductManager {
    private final List<Product> products;

    public ProductManager() {
        products = new LinkedList<>();
    }

    public void addProduct(Product product) {
        try {
            product.validateProduct();
            products.add(product);
        } catch (IllegalStateException e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }

    public void updateProduct(String oldID, Product updatedProduct) {
        try {
            updatedProduct.validateProduct();
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getProductID().equals(oldID)) {
                    products.set(i, updatedProduct);
                    return;
                }
            }
            throw new IllegalArgumentException("Product not found");
        } catch (IllegalStateException e) {
            System.out.println("Error updating product: " + e.getMessage());
        }
    }

    public void deleteProduct(String id) {
        products.removeIf(product -> product.getProductID().equals(id));
    }

    public Optional<Product> viewProduct(String productID) {
        return products.stream()
                      .filter(product -> product.getProductID().equals(productID))
                      .findFirst();
    }

    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("All Products:");
            for (int i = 0; i < products.size(); i++) {
                System.out.println("\n--- Product " + (i + 1) + " ---");
                System.out.println(products.get(i).getProductDetails());
            }
        }
    }

    public boolean productExists(String id) {
    return viewProduct(id).isPresent();
}
}