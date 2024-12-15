import java.util.*;

public class ECommerceSystem {
    public static void main(String[] args) {
        RecommendationSystem system = new RecommendationSystem();
        system.addProduct(new Item("Laptop", 1200, 4.5, "Electronics"));
        system.addProduct(new Item("Smartphone", 800, 4.6, "Electronics"));
        system.addProduct(new Item("Headphones", 200, 4.3, "Electronics"));
        system.addProduct(new Item("Book", 15, 4.8, "Books"));

        List<Item> sortedProducts = system.getSortedProducts();
        for (Item product : sortedProducts) {
            System.out.println(product.name + " - $" + product.price);
        }

        List<Item> electronics = system.getProductsByCategory("Electronics");
        for (Item product : electronics) {
            System.out.println("Recommended: " + product.name);
        }

        system.recordUserSearch("user1", new Item("Laptop", 1200, 4.5, "Electronics"));
        List<Item> personalized = system.getPersonalizedRecommendations("user1");
        for (Item product : personalized) {
            System.out.println("Personalized: " + product.name);
        }

    }
}