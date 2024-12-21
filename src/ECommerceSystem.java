import java.util.*;

public class ECommerceSystem {
    public static void main(String[] args) {
        RecommendationSystem system = new RecommendationSystem();
        String name;
        double price;
        String category;
        while (true) {
            System.out.println("A - Adding products");
            System.out.println("B - Deleting products");
            System.out.println("C - Displaying products");
            System.out.println("D - Searching item");
            System.out.println("E - Displaying all items by category");
            System.out.println("F - Displaying all items by user history");
            System.out.println("G - Exit");
            System.out.println("--------------------------------------------------------");
            System.out.print("Enter your choice: ");
            Scanner in = new Scanner(System.in);
            String choice = in.nextLine().toUpperCase();
            switch (choice) {
                case "A":
                    System.out.print("Enter item name: ");
                    name = in.nextLine();
                    if(name.isEmpty()) {
                        break;
                    }
                    price = getValidPrice(in);
                    in.nextLine();
                    System.out.print("Enter item category: ");
                    category = in.nextLine();
                    Item product = new Item(name.toLowerCase(),price,category.toLowerCase());
                    system.addItem(product);
                    break;
                case "B":
                    System.out.print("Enter item name: ");
                    name = in.nextLine();
                    if(name.isEmpty()) {
                        break;
                    }
                    System.out.print("Enter item price: ");
                    price = getValidPrice(in);
                    in.nextLine();
                    System.out.println("Enter item category: ");
                    category = in.nextLine();
                    Item item = new Item(name.toLowerCase(),price,category.toLowerCase());
                    system.deleteItem(item);
                    break;
                case "C":
                    List<Item> products = system.getSortedItems();
                    for (Item p : products) {
                        System.out.println(p);
                    }
                    break;
                case "D":
                    System.out.print("Enter item name: ");
                    name = in.nextLine();
                    if(name.isEmpty()) {
                        break;
                    }
                    Item searchedItem = system.searchByItemName(name.toLowerCase());
                    if(searchedItem != null) {
                        System.out.println("Item found: " + searchedItem);
                        system.addSearchHistory(searchedItem.name.toLowerCase());
                    }
                    else {
                        System.out.println("Item not found");
                    }
                    break;
                case "E":
                    System.out.print("Enter category: ");
                    category = in.nextLine();
                    List<Item> productsByCategory = system.getProductsByCategory(category.toLowerCase());
                    for (Item p : productsByCategory) {
                        System.out.println(p);
                    }
                    break;
                case "F":
                    List<Item> recommendedItems = system.recommendBasedOnHistory();
                    for (Item p : recommendedItems) {
                        System.out.println(p);
                    }
                    break;
                case "G":
                    return;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println("\n");
        }
    }

    private static double getValidPrice(Scanner in) {
        double price;
        while (true) {
            try {
                System.out.print("Enter item price: ");
                price = in.nextDouble();
                if(price > 0)
                {
                    return price;
                }
                else
                {
                    System.out.println("Price must be a positive number");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Price must be a number");
                in.nextLine();
            }
        }
    }
}