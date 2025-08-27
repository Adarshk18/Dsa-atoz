import java.util.*;

public class insertIntoBST1 {
    static class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = right = null;
        }
    }

    public static Node insertIntoBST(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.data) root.left = insertIntoBST(root.left, val);
        else root.right = insertIntoBST(root.right, val);
        return root;
    }

    // inorder traversal (sorted order for BST)
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            Node root = null;
            for (int i = 0; i < n; i++) {
                int val = in.nextInt();
                root = insertIntoBST(root, val);
            }

            int val = in.nextInt();
            root = insertIntoBST(root, val);

            System.out.print("[ ");
            inorder(root);
            System.out.println("]");
        }
    }
}
