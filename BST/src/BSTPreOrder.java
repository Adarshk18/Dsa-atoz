import java.util.*;

public class BSTPreOrder {
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

    public static Node bstFromPreorder(int[] preorder) {
        return bstFrom(preorder,Integer.MAX_VALUE,new int[]{0});
    }

    public static Node bstFrom(int[] preorder, int bound, int[] i){
        if (i[0]== preorder.length || preorder[i[0]]>bound) return null;

       Node root = new Node(preorder[i[0]++]);
       root.left = bstFrom(preorder,root.data,i);
       root.right = bstFrom(preorder,bound,i);
       return root;
    }

    static void printPreorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();

        while (t-->0){
            int n = in.nextInt();
           int[] preorder = new int[n];
            for (int i = 0; i < n; i++) {
                preorder[i] = in.nextInt();
            }

            Node root = bstFromPreorder(preorder);
            printPreorder(root);
            System.out.println();
        }
    }
}
