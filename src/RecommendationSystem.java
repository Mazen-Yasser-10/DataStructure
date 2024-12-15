import java.util.*;

class RecommendationSystem {
    private final Map<String, List<Item>> categoryMap = new HashMap<>();
    private final ProductBST bst = new ProductBST();
    private final Map<String, List<Item>> userHistory = new HashMap<>();

    public void addProduct(Item product) {
        bst.add(product);
        categoryMap.computeIfAbsent(product.category,
                k -> new ArrayList<>())
                .add(product);
    }

    public List<Item> getProductsByCategory(String category) {
        return categoryMap.getOrDefault(category, Collections.emptyList());
    }

    public List<Item> getSortedProducts() {
        return bst.getSortedProducts();
    }

    public void recordUserSearch(String userId, Item product) {
        userHistory.computeIfAbsent(userId,
                k -> new ArrayList<>())
                .add(product);
    }

    public List<Item> getPersonalizedRecommendations(String userId) {
        List<Item> history = userHistory.getOrDefault(userId, Collections.emptyList());
        return new ArrayList<>(history);
    }
    public void deleteProduct(Item product) {
        bst.delete(product);
        List<Item> products = categoryMap.get(product.category);
        if (products != null) {
            products.remove(product);
        }
    }
}