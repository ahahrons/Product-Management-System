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
        System.out.println("Enter product details:");
        
        String productID;
        while (true) {
        System.out.print("Enter Product ID: ");
        productID = scanner.nextLine();
        if (productID.isEmpty() || !productID.matches("\\d+")) {
            System.out.println("Invalid input. Product ID should be non-empty and numeric.");
        } else {
            break;
        }
    }

    String productName;
    while (true) {
    System.out.print("Enter Product Name: ");
    productName = scanner.nextLine();
    if (productName.isEmpty() || productName.matches(".*\\d.*")) {
        System.out.println("Invalid input. Product Name should not be empty or contain numbers.");
    } else {
        break;
    }
    }

    String category;
    while (true) {
    System.out.print("Enter Product Category (Perishable/Electronic/Clothing/Skincare): ");
    category = scanner.nextLine();
    if (category.isEmpty() || !category.matches("(?i)Perishable|Electronic|Clothing|Skincare")) {
        System.out.println("Invalid input. Category should be one of the following: Perishable, Electronic, Clothing, Skincare.");
    } else {
        break;
    }
    }

    double price;
    while (true) {
    System.out.print("Enter Product Price: ");
    String priceInput = scanner.nextLine();
    if (priceInput.isEmpty() || !priceInput.matches("\\d+(\\.\\d+)?")) {
        System.out.println("Invalid input. Please enter a valid price.");
    } else {
        price = Double.parseDouble(priceInput);
        if (price <= 0) {
            System.out.println("Invalid input. Price should be greater than zero.");
        } else {
            break;
        }
    }
    }

    String dateEntered;
    while (true) {
    System.out.print("Enter the Date (YYYY-MM-dd): ");
    dateEntered = scanner.nextLine();
    if (dateEntered.isEmpty() || !dateEntered.matches("\\d{4}-\\d{2}-\\d{2}")) {
        System.out.println("Invalid input. Please enter a valid date in YYYY-MM-dd format.");
    } else {
        break;
    }
    }

    String dateExpiry;
    while (true) {
    System.out.print("Enter the Date Expiry (YYYY-MM-dd): ");
    dateExpiry = scanner.nextLine();
    if (dateExpiry.isEmpty() || !dateExpiry.matches("\\d{4}-\\d{2}-\\d{2}")) {
        System.out.println("Invalid input. Please enter a valid date in YYYY-MM-dd format.");
    } else {
        break;
    }
    }

    System.out.println();
    System.out.println("Category Details:");

        Product product;
        switch (category.toLowerCase()) {
            case "perishable" -> {
                String storageInstructions;
                do {
                    System.out.print("Storage Instructions: ");
                    storageInstructions = scanner.nextLine();
                    if (storageInstructions.trim().isEmpty()) {
                        System.out.println("Storage Instructions cannot be empty. Please enter a valid value.");
                    } else {
                        try {
                            Double.valueOf(storageInstructions);
                            System.out.println("Storage Instructions cannot be a number. Please enter a valid value.");
                            storageInstructions = "";
                        } catch (NumberFormatException e) {
                            
                        }
                    }
                } while (storageInstructions.trim().isEmpty());
                product = new PerishableProduct(Integer.parseInt(productID), productName, category, price, dateEntered, dateExpiry, storageInstructions);
            }

                case "electronic" -> {
                    String brand;
                    do {
                        System.out.print("Brand: ");
                        brand = scanner.nextLine();
                        if (brand.trim().isEmpty()) {
                            System.out.println("Brand cannot be empty. Please enter a valid value.");
                        } else {
                            try {
                                Double.valueOf(brand);
                                System.out.println("Brand cannot be a number. Please enter a valid value.");
                                brand = "";
                            } catch (NumberFormatException e) {
                                
                            }
                        }
                    } while (brand.trim().isEmpty());
                    
                    int warrantyPeriod;
                    while (true) {
                        System.out.print("Warranty Period (months): ");
                        String warrantyInput = scanner.nextLine();
                        try {
                            warrantyPeriod = Integer.parseInt(warrantyInput);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Warranty Period must be an integer. Please enter a valid value.");                            
                        }
                    }
                    
                    product = new ElectronicProduct(productID, productName, category, price, dateEntered, dateExpiry, brand, warrantyPeriod);
            }

                case "clothing" -> {
                    String size;
                    do {
                        System.out.print("Size (S, M, L, XL, XXL): ");
                        size = scanner.nextLine().trim().toLowerCase();
                        if (!size.matches("s|m|l|xl|xxl")) {
                            System.out.println("Invalid size. Please enter one of the following: S, M, L, XL, XXL.");
                            size = "";
                        }
                    } while (size.isEmpty());
                    
                    String color;
                    do {
                        System.out.print("Color: ");
                        color = scanner.nextLine().trim();
                        if (color.isEmpty()) {
                            System.out.println("Color cannot be empty. Please enter a valid value.");
                        } else {
                            try {
                                Double.valueOf(color);
                                System.out.println("Color cannot be a number. Please enter a valid value.");
                                color = "";
                            } catch (NumberFormatException e) {
                                // Valid string input
                            }
                        }
                    } while (color.isEmpty());
                    
                    product = new ClothingProduct(productID, productName, category, price, dateEntered, dateExpiry, size, color);
            }
                
                case "skincare" -> {
                    double volume;
                    while (true) {
                        System.out.print("Volume (ml): ");
                        String volumeInput = scanner.nextLine().trim();
                        try {
                            volume = Double.parseDouble(volumeInput);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Volume must be a number. Please enter a valid value.");
                        }
                    }
                    product = new SkinCareProduct(productID, productName, category, price, dateEntered, dateExpiry, volume);
            }

            default -> throw new IllegalArgumentException("Invalid category");
        }

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

       String id;
        while (true) {
            System.out.print("Enter the new Product ID: ");
            id = scanner.nextLine().trim();
            try {
                Integer.valueOf(id);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Product ID must be an integer. Please enter a valid value.");
            }
        }

        String name;
        while (true) {
        System.out.print("Enter the new Product Name: ");
        name = scanner.nextLine();
        if (name.isEmpty() || name.matches(".*\\d.*")) {
            System.out.println("Invalid input. New Product Name should not be empty or contain numbers.");
        } else {
            break;
        }
        }

        String category;
        while (true) {
        System.out.print("Enter the new Product Category (Perishable/Electronic/Clothing/Skincare): ");
        category = scanner.nextLine();
            if (category.isEmpty() || !category.matches("(?i)Perishable|Electronic|Clothing|Skincare")) {
            System.out.println("Invalid input. Category should be one of the following: Perishable, Electronic, Clothing, Skincare.");
        } else {
            break;
        }
        }

        double price;
        while (true) {
        System.out.print("Enter the new Product Price: ");
        String priceInput = scanner.nextLine();
        if (priceInput.isEmpty() || !priceInput.matches("\\d+(\\.\\d+)?")) {
            System.out.println("Invalid input. Please enter a valid price.");
        } else {
            price = Double.parseDouble(priceInput);
            if (price <= 0) {
                System.out.println("Invalid input. Price should be greater than zero.");
            } else {
                break;
            }
        }
        }

        String dateEntered;
        while (true) {
        System.out.print("Enter the new Date (YYYY-MM-dd): ");
        dateEntered = scanner.nextLine();
        if (dateEntered.isEmpty() || !dateEntered.matches("\\d{4}-\\d{2}-\\d{2}")) {
            System.out.println("Invalid input. Please enter a valid date in YYYY-MM-dd format.");
        } else {
            break;
        }
        }

        String dateExpiry;
        while (true) {
        System.out.print("Enter the new Date Expiry (YYYY-MM-dd): ");
        dateExpiry = scanner.nextLine();
        if (dateExpiry.isEmpty() || !dateExpiry.matches("\\d{4}-\\d{2}-\\d{2}")) {
            System.out.println("Invalid input. Please enter a valid date in YYYY-MM-dd format.");
        } else {
            break;
        }
        }

        System.out.println();
        System.out.println("Category Details:");

        Product product;
        switch (category.toLowerCase()) {
            case "perishable" -> {
                String storageInstructions;
                do {
                    System.out.print("Storage Instructions: ");
                    storageInstructions = scanner.nextLine();
                    if (storageInstructions.trim().isEmpty()) {
                        System.out.println("Storage Instructions cannot be empty. Please enter a valid value.");
                    } else {
                        try {
                            Double.valueOf(storageInstructions);
                            System.out.println("Storage Instructions cannot be a number. Please enter a valid value.");
                            storageInstructions = "";
                        } catch (NumberFormatException e) {
                            
                        }
                    }
                } while (storageInstructions.trim().isEmpty());
                product = new PerishableProduct(Integer.parseInt(id), name, category, price, dateEntered, dateExpiry, storageInstructions);
            }

                case "electronic" -> {
                    String brand;
                    do {
                        System.out.print("Brand: ");
                        brand = scanner.nextLine();
                        if (brand.trim().isEmpty()) {
                            System.out.println("Brand cannot be empty. Please enter a valid value.");
                        } else {
                            try {
                                Double.valueOf(brand);
                                System.out.println("Brand cannot be a number. Please enter a valid value.");
                                brand = "";
                            } catch (NumberFormatException e) {
                                
                            }
                        }
                    } while (brand.trim().isEmpty());
                    
                    int warrantyPeriod;
                    while (true) {
                        System.out.print("Warranty Period (months): ");
                        String warrantyInput = scanner.nextLine();
                        try {
                            warrantyPeriod = Integer.parseInt(warrantyInput);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Warranty Period must be an integer. Please enter a valid value.");                            
                        }
                    }
                    
                    product = new ElectronicProduct(id, name, category, price, dateEntered, dateExpiry, brand, warrantyPeriod);
            }

                case "clothing" -> {
                    String size;
                    do {
                        System.out.print("Size (S, M, L, XL, XXL): ");
                        size = scanner.nextLine().trim().toLowerCase();
                        if (!size.matches("s|m|l|xl|xxl")) {
                            System.out.println("Invalid size. Please enter one of the following: S, M, L, XL, XXL.");
                            size = "";
                        }
                    } while (size.isEmpty());
                    
                    String color;
                    do {
                        System.out.print("Color: ");
                        color = scanner.nextLine().trim();
                        if (color.isEmpty()) {
                            System.out.println("Color cannot be empty. Please enter a valid value.");
                        } else {
                            try {
                                Double.valueOf(color);
                                System.out.println("Color cannot be a number. Please enter a valid value.");
                                color = "";
                            } catch (NumberFormatException e) {
                                // Valid string input
                            }
                        }
                    } while (color.isEmpty());
                    
                    product = new ClothingProduct(id, name, category, price, dateEntered, dateExpiry, size, color);
            }
                
                case "skincare" -> {
                    double volume;
                    while (true) {
                        System.out.print("Volume (ml): ");
                        String volumeInput = scanner.nextLine().trim();
                        try {
                            volume = Double.parseDouble(volumeInput);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Volume must be a number. Please enter a valid value.");
                        }
                    }
                    product = new SkinCareProduct(id, name, category, price, dateEntered, dateExpiry, volume);
            }

            default -> throw new IllegalArgumentException("Invalid category");
        }

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