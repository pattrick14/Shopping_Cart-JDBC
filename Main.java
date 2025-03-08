
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static UserDAO userDAO = new UserDAO();
   private static AdminService adminService = new AdminService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nWelcome to Online Shopping System");
            System.out.println("1. Admin Login");
            System.out.println("2. Customer Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) authenticateUser("Admin");
            else if (choice == 2) authenticateUser("Customer");
            else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice, try again.");
            }
        }
    }

    private static void authenticateUser(String userType) {
        System.out.print("\nEnter User Name: ");
        String userId = scanner.nextLine();
        scanner.nextLine(); // Consume newline
        String password = readPassword("Enter Password: ");

        if (userDAO.validateUser(userId, password, userType)) {
            System.out.println("Login successful!\n");
            if (userType.equals("Admin")) adminMenu();
            else customerMenu();
        } else {
            System.out.println("Invalid credentials. Try again.");
        }
    }

    private static String readPassword(String prompt) {
        System.out.print(prompt);
        StringBuilder password = new StringBuilder();
        try {
            while (true) {
                char ch = (char) System.in.read();
                if (ch == '\n' || ch == '\r') break;
                System.out.print("*");  // Mask password
                password.append(ch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(); // Move to new line
        return password.toString().trim();
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Stock Quantity: ");
                    int stock = scanner.nextInt();
                    adminService.addProduct(name, price, stock);
                    break;
                case 2:
                    adminService.viewProducts();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void customerMenu() {
        System.out.println("\nCustomer Menu - Feature to be implemented!");
    }
}
