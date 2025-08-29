import java.util.*;

public class ValidateTree {
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

    public static boolean isValidTree(Node root){
        return isBST(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isBST(Node root, long minVal, long maxVal){
        if (root==null) return true;

        if (root.data<=minVal || root.data>=maxVal){
            return false;
        }

        boolean leftTree = isBST(root.left,minVal, root.data);
        boolean rightTree = isBST(root.right, root.data, maxVal);

        return leftTree && rightTree;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            Node root = null;

            for (int i = 0; i < n; i++) {
                int val = in.nextInt();
                root = insertBST(root, val);
            }

            boolean tt = isValidTree(root);
            System.out.println(tt ? "true":"false");
        }
    }
}
