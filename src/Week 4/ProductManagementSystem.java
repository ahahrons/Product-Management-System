import java.util.Scanner;

public class ProductManagementSystem {
    private Scanner scanner;
    private ProductManager productManager;
    private ProductInterfaceHandler productInterfaceHandler;

    public ProductManagementSystem() {
        scanner = new Scanner(System.in);
        productManager = new ProductManager();
        productInterfaceHandler = new ProductInterfaceHandler(scanner, productManager);
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
                    productInterfaceHandler.addProductInterface();
                    break;
                case 2:
                    System.out.println();
                    productInterfaceHandler.viewProductInterface();
                    break;
                case 3:
                    System.out.println();
                    productInterfaceHandler.updateProductInterface();
                    break;
                case 4:
                    System.out.println();
                    productInterfaceHandler.deleteProductInterface();
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

    public static void main(String[] args) {
        ProductManagementSystem system = new ProductManagementSystem();
        system.handleUserInput();
    }
}