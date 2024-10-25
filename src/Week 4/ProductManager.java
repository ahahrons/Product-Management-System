import java.util.LinkedList;

public class ProductManager implements IProductManageable {
    private final LinkedList<Product> products;

    public ProductManager() {
        products = new LinkedList<>();
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void updateProduct(String oldID, Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID().equals(oldID)) {
                products.set(i, updatedProduct);
                return;
            }
        }
        throw new IllegalArgumentException("Product not found");
    }

    @Override
    public void deleteProduct(String id) {
        products.removeIf(product -> product.getProductID().equals(id));
    }

    @Override
    public Product viewProduct(String productID) {
        for (Product product : products) {
            if (product.getProductID().equals(productID)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            System.out.println("All Products:");
            for (int i = 0; i < products.size(); i++) {
                System.out.println("\n--- Product " + (i + 1) + " ---");
                System.out.println(products.get(i));
            }
        }
    }
}