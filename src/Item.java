class Item implements Comparable<Item> {
    String name;
    double price;
    double rating;
    String category;

    public Item(String name, double price, double rating, String category) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.category = category;
    }

    @Override
    public int compareTo(Item other) {
        return Double.compare(this.price, other.price);
    }
}