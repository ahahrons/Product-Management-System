// Product Management System
// Group Number 12
// Binuya, Licup, Pascual, Yulianto
// CYB - 201
import java.util.Scanner;
public class InputValidator {
    private static Scanner scanner = new Scanner(System.in);

    public static String validateNumericInput(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (input.isEmpty() || !input.matches("\\d+")) {
                System.out.println("Invalid input. It should be non-empty and numeric.");
            } else {
                break;
            }
        }
        return input;
    }

    public static String validateStringInput(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (input.isEmpty() || input.matches(".*\\d.*")) {
                System.out.println("Invalid input. It should not be empty or contain numbers.");
            } else {
                break;
            }
        }
        return input;
    }

    public static String validateNonEmptyInput(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Invalid input. It should not be empty.");
            } else {
                break;
            }
        }
        return input;
    }

    public static String validateSizeInput(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.matches("(?i)(Small|Medium|Large|XL|XXL)")) {
                break;
            } else {
                System.out.println("Invalid size. Please enter one of: Small, Medium, Large, XL, XXL");
            }
        }
        return input;
    }

    public static String validateCategoryInput(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("Perishable") || input.equalsIgnoreCase("Electronic") ||
                input.equalsIgnoreCase("Clothing") || input.equalsIgnoreCase("Skincare")) {
                break;
            } else {
                System.out.println("Invalid category. Please enter one of the following: Perishable, Electronic, Clothing, Skincare.");
            }
        }
        return input;
    }

    public static double validateDoubleInput(String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Double.parseDouble(scanner.nextLine().trim());
                if (value <= 0) {
                    System.out.println("Value must be greater than zero.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        return value;
    }

    public static String validateDateInput(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.matches("\\d{4}-\\d{2}-\\d{2}")) {
                // You could add actual date validation here
                break;
            } else {
                System.out.println("Invalid date format. Please use YYYY-MM-DD format.");
            }
        }
        return input;
    }

    public static String validateVolumeInput(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (input.matches("\\d+")) {
                break;
            } else {
                System.out.println("Invalid volume. Please enter a numeric value.");
            }
        }
        return input;
    }

}
