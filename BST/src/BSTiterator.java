import java.util.*;

public class BSTiterator {
    static class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = right = null;
        }
    }

    static Node insertBST(Node root, int key) {
        if (root == null) return new Node(key);
        if (key < root.data) root.left = insertBST(root.left, key);
        else root.right = insertBST(root.right, key);
        return root;
    }

    private Stack<Node> st = new Stack<>();

    // Constructor: push all left nodes
    public BSTiterator(Node root) {
        pushAll(root);
    }

    // Return next smallest
    public int next() {
        Node tempNode = st.pop();
        pushAll(tempNode.right);
        return tempNode.data;
    }

    // Check if next exists
    public boolean hasNext() {
        return !st.isEmpty();
    }

    // Push all left nodes
    private void pushAll(Node node) {
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();  // number of nodes
        Node root = null;

        // Build BST
        for (int i = 0; i < n; i++) {
            root = insertBST(root, in.nextInt());
        }

        // Create iterator
        BSTiterator it = new BSTiterator(root);

        // Print elements in sorted order
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
