// Product Management System
// Group Number 12
// Binuya, Licup, Pascual, Yulianto
// CYB - 201
import java.util.Optional;
import java.util.Scanner;

public class ProductManagementSystem {
    private final Scanner scanner;
    private final ProductManager productManager;
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
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println();
                    addProductInterface();
                    break;
                case 2:
                    System.out.println();
                    viewProductInterface();
                    break;
                case 3:
                    System.out.println();
                    updateProductInterface();
                    break;
                case 4:
                    System.out.println();
                    deleteProductInterface();
                    break;
                case 5:
                    System.out.println();
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
        try {
            System.out.println("Enter product details:");
            
            String productID = InputValidator.validateNumericInput("Enter Product ID: ");
            String productName = InputValidator.validateNonEmptyInput("Enter Product Name: ");
            String category = InputValidator.validateCategoryInput("Enter Product Category (Perishable/Electronic/Clothing/Skincare): ");
            double price = InputValidator.validateDoubleInput("Enter Product Price: ");
            String dateEntered = InputValidator.validateDateInput("Enter Date Entered (YYYY-MM-DD): ");
            String dateExpiry = InputValidator.validateDateInput("Enter Date Expiry (YYYY-MM-DD): ");
            
            System.out.println("\nCategory Details:");

            Product product = createProductByCategory(category, productID, productName, price, dateEntered, dateExpiry);
            productManager.addProduct(product);
            System.out.println("Product added successfully.");
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private Product createProductByCategory(String category, String productID, String productName, double price, String dateEntered, String dateExpiry) {
        return switch (category.toLowerCase()) {
            case "perishable" -> createPerishableProduct(productID, productName, category, price, dateEntered, dateExpiry);
            case "electronic" -> createElectronicProduct(productID, productName, category, price, dateEntered, dateExpiry);
            case "clothing" -> createClothingProduct(productID, productName, category, price, dateEntered, dateExpiry);
            case "skincare" -> createSkincareProduct(productID, productName, category, price, dateEntered, dateExpiry);
            default -> throw new IllegalArgumentException("Invalid category");
        };
    }

    private PerishableProduct createPerishableProduct(String productID, String productName, String category, double price, String dateEntered, String dateExpiry) {
        String storageInstructions = InputValidator.validateNonEmptyInput("Storage Instructions: ");
        return new PerishableProduct(productID, productName, category, price, dateEntered, dateExpiry, storageInstructions);
    }

    private ElectronicProduct createElectronicProduct(String productID, String productName, String category, double price, String dateEntered, String dateExpiry) {
        String brand = InputValidator.validateStringInput("Brand: ");
        int warrantyPeriod = Integer.parseInt(InputValidator.validateNumericInput("Warranty Period (months): "));
        return new ElectronicProduct(productID, productName, category, price, dateEntered, dateExpiry, brand, warrantyPeriod);
    }

    private ClothingProduct createClothingProduct(String productID, String productName, String category, double price, String dateEntered, String dateExpiry) {
        String size = InputValidator.validateSizeInput("Size (Small/Medium/Large/XL/XXL): ");
        String color = InputValidator.validateStringInput("Color: ");
        return new ClothingProduct(productID, productName, category, price, dateEntered, dateExpiry, size, color);
    }

    private SkincareProduct createSkincareProduct(String productID, String productName, String category, double price, String dateEntered, String dateExpiry) {
        double volume = InputValidator.validateDoubleInput("Volume (ml): ");
        return new SkincareProduct(productID, productName, category, price, dateEntered, dateExpiry, volume);
    }

    private void viewProductInterface() {
        System.out.print("Enter product ID to view: ");
        String id = scanner.nextLine();
        Optional<Product> product = productManager.viewProduct(id);
        product.ifPresentOrElse(
            p -> System.out.println(p.getProductDetails()),
            () -> System.out.println("Product not found.")
        );
    }

    private void updateProductInterface() {
        System.out.print("Enter product ID to update: ");
        String oldID = scanner.nextLine();
        Optional<Product> existingProduct = productManager.viewProduct(oldID);
        
        if (existingProduct.isEmpty()) {
            System.out.println("Product not found.");
            return;
        }

        try {
            String id = InputValidator.validateNumericInput("Enter the new Product ID: ");
            String name = InputValidator.validateNonEmptyInput("Enter the new Product Name: ");
            String category = InputValidator.validateCategoryInput("Enter the new Product Category (Perishable/Electronic/Clothing/Skincare): ");
            double price = InputValidator.validateDoubleInput("Enter the new Product Price: ");
            String dateEntered = InputValidator.validateDateInput("Enter the new Date Entered (YYYY-MM-DD): ");
            String dateExpiry = InputValidator.validateDateInput("Enter the new Date Expiry (YYYY-MM-DD): ");
            
            System.out.println("\nCategory Details:");
            Product updatedProduct = createProductByCategory(category, id, name, price, dateEntered, dateExpiry);
            productManager.updateProduct(oldID, updatedProduct);
            System.out.println("Product updated successfully.");
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error updating product: " + e.getMessage());
        }
    }

    private void deleteProductInterface() {
        String id;
        while (true) {
            System.out.print("Enter product ID to delete: ");
            id = scanner.nextLine();
            if (id.trim().isEmpty()) {
                System.out.println("Product ID cannot be empty. Please try again.");
            } else if (!productManager.productExists(id)) {
                System.out.println("Product ID does not exist. Please try again.");
            } else {
                break;
            }
        }
        productManager.deleteProduct(id);
        System.out.println("Product deleted successfully.");
    }
    public static void main(String[] args) {
        ProductManagementSystem system = new ProductManagementSystem();
        system.handleUserInput();
    }
}