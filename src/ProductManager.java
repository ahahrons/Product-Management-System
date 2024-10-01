import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private List<Product> products;
    private Scanner scanner;

    public ProductManager() {
        products = new LinkedList<>();
        scanner = new Scanner(System.in);
    }

    public void addProduct() {
        try {
            System.out.print("Enter product ID: ");
            String productID = scanner.nextLine();
            System.out.print("Enter product name: ");
            String productName = scanner.nextLine();
            System.out.print("Enter product category: ");
            String category = scanner.nextLine();
            System.out.print("Enter product price: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter the date entered (YYYY-MM-DD): ");
            LocalDate dateEntered = LocalDate.parse(scanner.nextLine());
            System.out.print("Enter the expiry date (YYYY-MM-DD): ");
            LocalDate dateExpiry = LocalDate.parse(scanner.nextLine());

            Product product = new Product(productID, productName, category, price, dateEntered, dateExpiry);
            products.add(product);
            System.out.println("Product added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }

    public void updateProduct() {
        try {
            System.out.print("Enter product ID to update: ");
            String id = scanner.nextLine();
            Product product = findProductById(String productID);
            if (product == null) {
                System.out.println("Product not found.");
                return;
            }

    private Product findProductById(String productID) {
        for (Product product : products) {
            if (product.getProductID() == productID) {
                return product;
            }
        }
        return null;
    }


}