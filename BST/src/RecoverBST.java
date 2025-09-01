import java.util.*;

public class RecoverBST {
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

    private static Node prev;
    private static Node first;
    private static Node middle;
    private static Node last;

    private static void inOrder(Node root){
        if (root==null) return;

        inOrder(root.left);

        if (prev!=null && root.data<prev.data){
            if (first==null){
                first = prev;
                middle = root;
            }else{
                last = root;
            }

        }
        prev = root;
        inOrder(root.right);
    }

    public static void recoverTree(Node root) {
        first = middle = last = null;
        prev = new Node(Integer.MIN_VALUE);
        inOrder(root);

        if (first!=null && last!=null){
            int t = first.data;
            first.data = last.data;
            last.data = t;
        }else{
            int t = first.data;
            first.data = middle.data;
            middle.data = t;
        }
    }

    public static List<Integer> inorderList(Node root) {
        List<Integer> res = new ArrayList<>();
        inorderHelper(root, res);
        return res;
    }

    private static void inorderHelper(Node root, List<Integer> res) {
        if (root == null) return;
        inorderHelper(root.left, res);
        res.add(root.data);
        inorderHelper(root.right, res);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node root = null;

        for (int i = 0; i < n; i++) {
            root = insertBST(root, in.nextInt());
        }

        recoverTree(root);
        List<Integer> res = inorderList(root);
        System.out.println(res);

    }
}
