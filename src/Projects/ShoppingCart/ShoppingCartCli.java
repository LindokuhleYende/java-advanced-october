package Projects.ShoppingCart;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//import java.util.stream.Collectors;
//
//
//
//public class ShoppingCartCli {
//    private static Scanner scanner = new Scanner(System.in);
//    private static ShoppingCart cart = new ShoppingCart();
//
//    // ANSI Color codes for terminal styling
//    private static final String RESET = "\u001B[0m";
//    private static final String RED = "\u001B[31m";
//    private static final String GREEN = "\u001B[32m";
//    private static final String YELLOW = "\u001B[33m";
//    private static final String BLUE = "\u001B[34m";
//    private static final String PURPLE = "\u001B[35m";
//    private static final String CYAN = "\u001B[36m";
//    private static final String WHITE = "\u001B[37m";
//    private static final String BOLD = "\u001B[1m";
//    private static final String BG_BLUE = "\u001B[44m";
//    private static final String BG_GREEN = "\u001B[42m";
//
//    public static void main(String[] args) {
//        printBanner();
//
//        boolean running = true;
//
//        while (running) {
//            try {
//                displayMenu();
//                int choice = getIntInput(CYAN + "Enter your choice: " + RESET);
//
//                switch (choice) {
//                    case 1 -> addProduct();
//                    case 2 -> deleteProduct();
//                    case 3 -> cart.displayCart();
//                    case 4 -> performCheckout();
//                    case 5 -> {
//                        System.out.println(GREEN + BOLD + "\n✓ Thank you for using our shopping cart!" + RESET);
//                        System.out.println(YELLOW + "See you again soon! 👋\n" + RESET);
//                        running = false;
//                    }
//                    default -> System.out.println(RED + "\n✗ Invalid choice! Please try again.\n" + RESET);
//                }
//
//            } catch (Exception e) {
//                System.out.println(RED + "\n✗ Error: " + e.getMessage() + "\n" + RESET);
//            }
//        }
//
//        scanner.close();
//    }
//
//    private static void printBanner() {
//        System.out.println(CYAN + BOLD);
//        System.out.println("\n╔════════════════════════════════════════════════════════════════════╗");
//        System.out.println("║                                                                    ║");
//        System.out.println("║          🛒  SHOPPING CART APPLICATION  🛍️                        ║");
//        System.out.println("║                                                                    ║");
//        System.out.println("║              Your One-Stop Shopping Solution                       ║");
//        System.out.println("║                                                                    ║");
//        System.out.println("╚════════════════════════════════════════════════════════════════════╝");
//        System.out.println(RESET);
//    }
//
//    private static void displayMenu() {
//        System.out.println(BLUE + BOLD + "╔══════════════════════════════════════════════════════════════╗" + RESET);
//        System.out.println(BLUE + BOLD + "║" + RESET + WHITE + BOLD + "                      MAIN MENU                           " + BLUE + BOLD + "║" + RESET);
//        System.out.println(BLUE + BOLD + "╠══════════════════════════════════════════════════════════════╣" + RESET);
//        System.out.println(BLUE + BOLD + "║" + RESET + GREEN + "  1. 📦 Add Product to Cart                               " + BLUE + BOLD + "║" + RESET);
//        System.out.println(BLUE + BOLD + "║" + RESET + RED + "  2. 🗑️  Delete Product from Cart                         " + BLUE + BOLD + "║" + RESET);
//        System.out.println(BLUE + BOLD + "║" + RESET + CYAN + "  3. 👁️  View Cart                                         " + BLUE + BOLD + "║" + RESET);
//        System.out.println(BLUE + BOLD + "║" + RESET + PURPLE + "  4. 💳 Checkout                                           " + BLUE + BOLD + "║" + RESET);
//        System.out.println(BLUE + BOLD + "║" + RESET + YELLOW + "  5. 🚪 Exit                                               " + BLUE + BOLD + "║" + RESET);
//        System.out.println(BLUE + BOLD + "╚══════════════════════════════════════════════════════════════╝" + RESET);
//        System.out.println();
//    }
//
//    private static void addProduct() {
//        try {
//            System.out.println("\n--- Add Product ---");
//
//            System.out.print("Enter product name: ");
//            String name = scanner.nextLine().trim();
//
//            if (name.isEmpty()) {
//                throw new Exception("Product name cannot be empty");
//            }
//
//            double price = getDoubleInput("Enter price (R): ");
//            int quantity = getIntInput("Enter quantity: ");
//
//            Product product = new Product(name, price, quantity);
//            cart.addItem(product);
//
//            System.out.println();
//
//        } catch (Exception e) {
//            System.out.println("\n*** Error adding product: " + e.getMessage() + " ***\n");
//        }
//    }
//
//    private static void deleteProduct() {
//        try {
//            if (cart.isEmpty()) {
//                System.out.println("\n*** Cart is empty! Nothing to delete. ***\n");
//                return;
//            }
//
//            cart.displayCart();
//
//            System.out.println("Available products:");
//            cart.getProductNames().forEach(name -> System.out.println("  - " + name));
//
//            System.out.print("\nEnter product name to delete: ");
//            String name = scanner.nextLine().trim();
//
//            cart.deleteItem(name);
//            System.out.println();
//
//        } catch (Exception e) {
//            System.out.println("\n*** " + e.getMessage() + " ***\n");
//        }
//    }
//
//    private static void performCheckout() {
//        try {
//            cart.checkout();
//        } catch (Exception e) {
//            System.out.println("\n*** " + e.getMessage() + " ***\n");
//        }
//    }
//
//    private static int getIntInput(String prompt) {
//        while (true) {
//            try {
//                System.out.print(prompt);
//                String input = scanner.nextLine().trim();
//                return Integer.parseInt(input);
//            } catch (NumberFormatException e) {
//                System.out.println("*** Invalid number! Please try again. ***");
//            }
//        }
//    }
//
//    private static double getDoubleInput(String prompt) {
//        while (true) {
//            try {
//                System.out.print(prompt);
//                String input = scanner.nextLine().trim();
//                return Double.parseDouble(input);
//            } catch (NumberFormatException e) {    }
//
//            System.out.println("*** Invalid number! Please try again. ***");
//            }
//        }
//}