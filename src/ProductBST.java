import java.util.ArrayList;
import java.util.List;

class ProductBST {
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
        deleteHelper(root, target);
    }
    private void deleteHelper(Node cur, Item target){
        if(cur == null) return;
        if(target.compareTo(cur.product) < 0) {
            if(target.compareTo(cur.left.product) != 0) deleteHelper(cur.left, target);
            else {
                if(cur.left.left == cur.left.right) cur.left = null;
                else if(cur.left.left == null) cur.left = cur.left.right;
                else if(cur.left.right == null) cur.left = cur.left.left;
                else{
                    Node mn = minNode(cur.left.right);
                    cur.left.product = mn.product;
                    deleteHelper(cur.left.right,mn.product);
                }
            }
        }
        else if(target.compareTo(cur.product) > 0) {
            if(target.compareTo(cur.right.product) != 0) deleteHelper(cur.right, target);
            else {
                if(cur.right.left == cur.right.right) cur.right = null;
                else if(cur.right.left == null) cur.right = cur.right.right;
                else if(cur.right.right == null) cur.right = cur.right.left;
                else{
                    Node mn = minNode(cur.right.right);
                    cur.right.product = mn.product;
                    deleteHelper(cur.right.right,mn.product);
                }
            }
        }
    }
    private Node minNode(Node cur){
        while(cur != null && cur.left != null) cur = cur.left;
        return cur;
    }
}