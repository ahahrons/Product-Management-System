import java.util.Scanner;

public class ProductManagementSystem {
    private Scanner scanner;
    private ProductManager productManager;

    public ProductManagementSystem() {
        scanner = new Scanner(System.in);
        productManager = new ProductManager();
    }

    public void displayMenu() {
        System.out.println("--- Product Management System ---");
        System.out.println("1. Add Product");
        System.out.println("2. View Product");
        System.out.println("3. Update Product");
        System.out.println("4. Delete Product");
        System.out.println("5. Display All Products");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    public void handleUserInput() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addProductInterface();
                    break;
                case 2:
                    viewProductInterface();
                    break;
                case 3:
                    updateProductInterface();
                    break;
                case 4:
                    deleteProductInterface();
                    break;
                case 5:
                    productManager.displayAllProducts();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addProductInterface() {
        System.out.println("Enter product details:");
        System.out.print("Enter Product ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Product Category (Perishable/Electronic/Clothing/Skincare): ");
        String category = scanner.nextLine();
        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter the Date (YYYY-MM-dd): ");
        String dateEntered = scanner.nextLine();
        System.out.print("Enter the Date Expiry (YYYY-MM-dd): ");
        String dateExpiry = scanner.nextLine();

        Product product = new Product(id, name, category, price, dateEntered, dateExpiry);
        productManager.addProduct(product);
        System.out.println("Product added successfully.");
    }

    private void viewProductInterface() {
        System.out.print("Enter product ID to view: ");
        String id = scanner.nextLine();
        Product product = productManager.viewProduct(id);
        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Product not found.");
        }
    }

    private void updateProductInterface() {
        System.out.print("Enter product ID to update: ");
        String oldID = scanner.nextLine();
        Product existingProduct = productManager.viewProduct(oldID);
        if (existingProduct == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.print("Enter the new Product ID: ");
        String id = scanner.nextLine();
        id = id.isEmpty() ? existingProduct.getProductID() : id;

        System.out.print("Enter the new Product Name: ");
        String name = scanner.nextLine();
        name = name.isEmpty() ? existingProduct.getProductName() : name;

        System.out.print("Enter the new Product Category (Perishable/Electronic/Clothing/Skincare): ");
        String category = scanner.nextLine();
        category = category.isEmpty() ? existingProduct.getCategory() : category;

        System.out.print("Enter the new Product Price: ");
        double price = scanner.nextDouble();
        price = (price == -1) ? existingProduct.getPrice() : price;

        System.out.print("Enter the new Date (YYYY-MM-dd): ");
        String dateEntered = scanner.nextLine();
        dateEntered = dateEntered.isEmpty() ? existingProduct.getDateEntered() : dateEntered;
        scanner.nextLine();

        System.out.print("Enter the new Date Expiry (YYYY-MM-dd): ");
        String dateExpiry = scanner.nextLine();
        dateExpiry = dateExpiry.isEmpty() ? existingProduct.getDateExpiry() : dateExpiry;

        Product updatedProduct = new Product(id, name, category, price, dateEntered, dateExpiry);
        productManager.updateProduct(oldID, updatedProduct);
        System.out.println("Product updated successfully.");

    }

    private void deleteProductInterface() {
        System.out.print("Enter product ID to delete: ");
        String id = scanner.nextLine();
        productManager.deleteProduct(id);
        System.out.println("Product deleted successfully.");
    }

    public static void main(String[] args) {
        ProductManagementSystem system = new ProductManagementSystem();
        system.handleUserInput();
    }
}