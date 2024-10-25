public class UserValidation {
    
    public static String validateProductID(String productID) {
        if (productID.isEmpty() || !productID.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid input. Product ID should contains number and should not be empty.");
        }
        return productID;
    }

    public static String validateProductName(String productName) {
        if (productName.isEmpty()) {
            throw new IllegalArgumentException("Invalid input. Product Name should not be empty.");
        }
        return productName;
    }

    public static String validateCategory(String category) {
        if (category.isEmpty() || !category.matches("(?i)Perishable|Electronic|Clothing|Skincare")) {
            throw new IllegalArgumentException("Invalid input. Category should be one of the following: Perishable, Electronic, Clothing, Skincare.");
        }
        return category;
    }

    public static double validatePrice(String priceInput) {
        if (priceInput.isEmpty() || !priceInput.matches("\\d+(\\.\\d+)?")) {
            throw new IllegalArgumentException("Invalid input. Please enter a valid price.");
        }
        double price = Double.parseDouble(priceInput);
        if (price <= 0) {
            throw new IllegalArgumentException("Invalid input. Price should be greater than zero.");
        }
        return price;
    }

    public static String validateDate(String date) {
        if (date.isEmpty() || !date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new IllegalArgumentException("Invalid input. Please enter a valid date in YYYY-MM-dd format.");
        }
        return date;
    }

    public static String validateStorageInstructions(String instructions) {
        if (instructions.trim().isEmpty()) {
            throw new IllegalArgumentException("Storage Instructions cannot be empty. Please enter a valid value.");
        }
        return instructions.trim();
    }

    public static String validateBrand(String brand) {
        if (brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be empty. Please enter a valid value.");
        }
        try {
            Double.valueOf(brand);
            throw new IllegalArgumentException("Brand cannot be a number. Please enter a valid value.");
        } catch (NumberFormatException e) {
            return brand.trim();
        }
    }

    public static int validateWarrantyPeriod(String warrantyInput) {
        try {
            return Integer.parseInt(warrantyInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Warranty Period must be a number. Please enter a valid value.");
        }
    }

    public static String validateSize(String size) {
        size = size.trim().toLowerCase();
        if (!size.matches("s|m|l|xl|xxl")) {
            throw new IllegalArgumentException("Invalid size. Please enter one of the following: S, M, L, XL, XXL.");
        }
        return size;
    }

    public static String validateColor(String color) {
        if (color.trim().isEmpty() || color.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Color cannot be empty or contain numbers. Please enter a valid value.");
        }
        return color.trim();
    }
    
    public static double validateVolume(String volumeInput) {
        try {
            return Double.parseDouble(volumeInput.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Volume must be a number. Please enter a valid value.");
        }
    }
}