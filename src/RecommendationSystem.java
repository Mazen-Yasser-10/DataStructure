import java.util.*;

class RecommendationSystem {
    private final Map<String, List<Item>> categoryMap = new HashMap<>();
    private final BST bst = new BST();
    private final Map<String, List<String>> userSearchHistory = new HashMap<>();

    public void addItem(Item item) {
        bst.add(item);
        categoryMap.computeIfAbsent(item.category,
                k -> new ArrayList<>())
                .add(item);
    }

    public List<Item> getProductsByCategory(String category) {
        return categoryMap.getOrDefault(category, Collections.emptyList());
    }

    public List<Item> getSortedItems() {
        return bst.getSortedItems();
    }
    public void deleteItem(Item item) {
        bst.delete(item);
        List<Item> items = categoryMap.get(item.category);
        if (items != null) {
            items.remove(item);
        }
    }
    public Item searchByItemName(String itemName) {
        return bst.search(itemName);
    }
    public void addSearchHistory(String itemName) {
        userSearchHistory.computeIfAbsent("defaultUser", k -> new ArrayList<>()).add(itemName);
    }

    public List<Item> recommendBasedOnHistory() {
        List<String> history = userSearchHistory.getOrDefault("defaultUser", Collections.emptyList());
        if (history.isEmpty()) return Collections.emptyList();

        Set<Item> recommendations = new HashSet<>();
        for (String itemName : history) {
            Item searchedItem = searchByItemName(itemName);
            if (searchedItem != null) {
                recommendations.addAll(getProductsByCategory(searchedItem.category));
            }
        }
        return new ArrayList<>(recommendations);
    }
}