import java.util.ArrayList;
import java.util.List;

class ItemBST {
    private Node root;

    public void add(Item product) {
        root = addHelper(root, product);
    }

    private Node addHelper(Node node, Item product) {
        if (node == null) return new Node(product);
        if (product.compareTo(node.product) < 0) node.left = addHelper(node.left, product);
        else node.right = addHelper(node.right, product);
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

    public void delete(Item target) {
        root = deleteHelper(root, target);
    }

    private Node deleteHelper(Node cur, Item target) {
        if (cur == null) return null;

        if (target.compareTo(cur.product) < 0) {
            cur.left = deleteHelper(cur.left, target);
        } else if (target.compareTo(cur.product) > 0) {
            cur.right = deleteHelper(cur.right, target);
        } else {
            if (cur.left == null && cur.right == null) {
                return null;
            } else if (cur.left == null) {
                return cur.right;
            } else if (cur.right == null) {
                return cur.left;
            } else {
                Node mn = minNode(cur.right);
                cur.product = mn.product;
                cur.right = deleteHelper(cur.right, mn.product);
            }
        }
        return cur;
    }

    private Node minNode(Node cur) {
        while (cur != null && cur.left != null) cur = cur.left;
        return cur;
    }

    public Item search(Item target) {
        return searchHelper(root, target);
    }

    private Item searchHelper(Node root, Item target) {
        if (root == null) return null;
        if (target.compareTo(root.product) == 0) return root.product;
        if (target.compareTo(root.product) < 0) return searchHelper(root.left, target);
        return searchHelper(root.right, target);
    }
}