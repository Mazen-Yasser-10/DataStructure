import java.util.ArrayList;
import java.util.List;

class ProductBST {
    private Node root;
    public void add(Item product) {
        root = add(root, product);
    }

    private Node add(Node node, Item product) {
        if (node == null) return new Node(product);
        if (product.compareTo(node.product) < 0) node.left = add(node.left, product);
        else node.right = add(node.right, product);
        return node;
    }

    public List<Item> getSortedProducts() {
        List<Item> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(Node node, List<Item> result) {
        if (node == null) return;
        inorderTraversal(node.left, result);
        result.add(node.product);
        inorderTraversal(node.right, result);
    }

    public void delete(Item product) {
        if(product.equals(root)) {

        }
    }
}