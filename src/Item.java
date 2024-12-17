class Item implements Comparable<Item> {
    String name;
    double price;
    String category;

    public Item(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public int compareTo(Item other) {
        return Double.compare(this.price, other.price);
    }
}