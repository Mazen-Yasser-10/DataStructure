import java.util.ArrayList;
import java.util.List;

public class BST {
    private Node root;

    public void add(Item item) {
        root = addHelper(root, item);
    }

    private Node addHelper(Node node, Item item) {
        if (node == null) return new Node(item);
        if (item.name.compareTo(node.item.name) < 0) node.left = addHelper(node.left, item);
        else node.right = addHelper(node.right, item);
        return node;
    }

    public List<Item> getSortedItems() {
        List<Item> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(Node node, List<Item> items) {
        if (node == null) return;
        inorder(node.left, items);
        items.add(node.item);
        inorder(node.right, items);
    }

    public void delete(Item target) {
        root = deleteHelper(root, target);
    }

    private Node deleteHelper(Node cur, Item target) {
        if (cur == null) return null;

        if (target.name.compareTo(cur.item.name) < 0) {
            cur.left = deleteHelper(cur.left, target);
        } else if (target.name.compareTo(cur.item.name) > 0) {
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
                cur.item = mn.item;
                cur.right = deleteHelper(cur.right, mn.item);
            }
        }
        return cur;
    }

    private Node minNode(Node cur) {
        while (cur != null && cur.left != null) cur = cur.left;
        return cur;
    }

    public Item search(String targetName) {
        return searchHelper(root, targetName);
    }

    private Item searchHelper(Node root, String targetName) {
        if (root == null) return null;
        if (targetName.compareTo(root.item.name) == 0) return root.item;
        if (targetName.compareTo(root.item.name) < 0) return searchHelper(root.left, targetName);
        return searchHelper(root.right, targetName);
    }
    class Node {
        Item item;
        Node left, right;
        Node(Item item) {
            this.item = item;
        }
    }
}
