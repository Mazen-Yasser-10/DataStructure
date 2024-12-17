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
            System.out.println("D - Searching product");
            System.out.println("E - Exit");
            System.out.println("--------------------------------------------------------");
            System.out.print("Enter your choice: ");
            Scanner in = new Scanner(System.in);
            String choice = in.nextLine();
            switch (choice) {
                case "A":
                    System.out.print("Enter product name: ");
                    name = in.nextLine();
                    System.out.print("Enter product price: ");
                    price = in.nextDouble();
                    in.nextLine();
                    System.out.print("Enter product category: ");
                    category = in.nextLine();
                    Item product = new Item(name,price,category);
                    system.addItem(product);
                    break;
                case "B":
                    System.out.print("Enter product name: ");
                    name = in.nextLine();
                    System.out.print("Enter product price: ");
                    price = in.nextDouble();
                    System.out.println("Enter product category: ");
                    category = in.nextLine();
                    Item item = new Item(name,price,category);
                    system.deleteItem(item);
                    break;
                case "C":
                    List<Item> products = system.getSortedProducts();
                    for (Item p : products) {
                        System.out.println(p);
                    }
                    break;
                case "D":
                    System.out.print("Enter product name: ");
                    name = in.nextLine();
                    System.out.print("Enter product price: ");
                    price = in.nextDouble();
                    in.nextLine();
                    System.out.print("Enter product category: ");
                    category = in.nextLine();
                    item = new Item(name,price,category);
                    System.out.println(system.searchItem(item) == null? "Not Found" : "Found");;
                    break;
                case "E":
                    return;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println("\n");
        }
    }
}