import java.util.*;

public class LCA {
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

    public static Node lowestCommonAncestor(Node root, int p, int q){
        if (root==null) return null;
        int curr = root.data;
        if (curr<p && curr<q){
            return lowestCommonAncestor(root.right,p,q);
        }

        if (curr>p && curr>q){
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;
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
            int p = in.nextInt();
            int q = in.nextInt();

            Node lca = lowestCommonAncestor(root,p,q);
            if (lca!=null){
                System.out.println(lca.data);
            }

        }
    }
}
