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
            try {
                productID = UserValidation.validateProductID(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String productName;
        while (true) {
            System.out.print("Enter Product Name: ");
            try {
                productName = UserValidation.validateProductName(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String category;
        while (true) {
            System.out.print("Enter Product Category (Perishable/Electronic/Clothing/Skincare): ");
            try {
                category = UserValidation.validateCategory(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        double price;
        while (true) {
            System.out.print("Enter Product Price: ");
            try {
                price = UserValidation.validatePrice(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String dateEntered;
        while (true) {
            System.out.print("Enter the Date (YYYY-MM-dd): ");
            try {
                dateEntered = UserValidation.validateDate(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String dateExpiry;
        while (true) {
            System.out.print("Enter the Date Expiry (YYYY-MM-dd): ");
            try {
                dateExpiry = UserValidation.validateDate(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println();
        System.out.println("Category Details:");

        Product product;
        switch (category.toLowerCase()) {
            case "perishable" -> {
                String storageInstructions;
                while (true) {
                    System.out.print("Storage Instructions: ");
                    try {
                        storageInstructions = UserValidation.validateStorageInstructions(scanner.nextLine());
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                product = new PerishableProduct(productID, productName, category, price, dateEntered, dateExpiry, storageInstructions);
            }

            case "electronic" -> {
                String brand;
                while (true) {
                    System.out.print("Brand: ");
                    try {
                        brand = UserValidation.validateBrand(scanner.nextLine());
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                
                int warrantyPeriod;
                while (true) {
                    System.out.print("Warranty Period (months): ");
                    try {
                        warrantyPeriod = UserValidation.validateWarrantyPeriod(scanner.nextLine());
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                product = new ElectronicProduct(productID, productName, category, price, dateEntered, dateExpiry, brand, warrantyPeriod);
            }

            case "clothing" -> {
                String size;
                while (true) {
                    System.out.print("Size (S, M, L, XL, XXL): ");
                    try {
                        size = UserValidation.validateSize(scanner.nextLine());
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                
                String color;
                while (true) {
                    System.out.print("Color: ");
                    try {
                        color = UserValidation.validateColor(scanner.nextLine());
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                product = new ClothingProduct(productID, productName, category, price, dateEntered, dateExpiry, size, color);
            }
            
            case "skincare" -> {
                double volume;
                while (true) {
                    System.out.print("Volume (ml): ");
                    try {
                        volume = UserValidation.validateVolume(scanner.nextLine());
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
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
            try {
                id = UserValidation.validateProductID(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String name;
        while (true) {
            System.out.print("Enter the new Product Name: ");
            try {
                name = UserValidation.validateProductName(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String category;
        while (true) {
            System.out.print("Enter the new Product Category (Perishable/Electronic/Clothing/Skincare): ");
            try {
                category = UserValidation.validateCategory(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        double price;
        while (true) {
            System.out.print("Enter the new Product Price: ");
            try {
                price = UserValidation.validatePrice(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String dateEntered;
        while (true) {
            System.out.print("Enter the new Date (YYYY-MM-dd): ");
            try {
                dateEntered = UserValidation.validateDate(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String dateExpiry;
        while (true) {
            System.out.print("Enter the new Date Expiry (YYYY-MM-dd): ");
            try {
                dateExpiry = UserValidation.validateDate(scanner.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println();
        System.out.println("Category Details:");

        Product product;
        switch (category.toLowerCase()) {
            case "perishable" -> {
                String storageInstructions;
                while (true) {
                    System.out.print("Storage Instructions: ");
                    try {
                        storageInstructions = UserValidation.validateStorageInstructions(scanner.nextLine());
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                product = new PerishableProduct(id, name, category, price, dateEntered, dateExpiry, storageInstructions);
            }

            case "electronic" -> {
                String brand;
                while (true) {
                    System.out.print("Brand: ");
                    try {
                        brand = UserValidation.validateBrand(scanner.nextLine());
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                
                int warrantyPeriod;
                while (true) {
                    System.out.print("Warranty Period (months): ");
                    try {
                        warrantyPeriod = UserValidation.validateWarrantyPeriod(scanner.nextLine());
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                product = new ElectronicProduct(id, name, category, price, dateEntered, dateExpiry, brand, warrantyPeriod);
            }

            case "clothing" -> {
                String size;
                while (true) {
                    System.out.print("Size (S, M, L, XL, XXL): ");
                    try {
                        size = UserValidation.validateSize(scanner.nextLine());
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                
                String color;
                while (true) {
                    System.out.print("Color: ");
                    try {
                        color = UserValidation.validateColor(scanner.nextLine());
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                product = new ClothingProduct(id, name, category, price, dateEntered, dateExpiry, size, color);
            }
            
            case "skincare" -> {
                double volume;
                while (true) {
                    System.out.print("Volume (ml): ");
                    try {
                        volume = UserValidation.validateVolume(scanner.nextLine());
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                product = new SkinCareProduct(id, name, category, price, dateEntered, dateExpiry, volume);
            }

            default -> throw new IllegalArgumentException("Invalid category");
        }

        productManager.updateProduct(oldID, product);
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