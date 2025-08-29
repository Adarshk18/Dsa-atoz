import java.util.*;

public class KthSmallest {
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

    // Reverse inorder for kth largest
    private static void reverseInorder(Node node, int[] counter, int k, int[] kthLargest) {
        if (node == null || counter[0] >= k) return;

        reverseInorder(node.right, counter, k, kthLargest);
        counter[0]++;

        if (counter[0] == k) {
            kthLargest[0] = node.data;
            return;
        }

        reverseInorder(node.left, counter, k, kthLargest);
    }

    // Normal inorder for kth smallest
    private static void inorder(Node node, int[] counter, int k, int[] kthSmallest) {
        if (node == null || counter[0] >= k) return;

        inorder(node.left, counter, k, kthSmallest);
        counter[0]++;

        if (counter[0] == k) {
            kthSmallest[0] = node.data;
            return;
        }

        inorder(node.right, counter, k, kthSmallest);
    }

    // Function to get kth largest and kth smallest
    public static int[] findKthValues(Node root, int k) {
        int[] kthLargest = new int[]{Integer.MIN_VALUE};
        int[] kthSmallest = new int[]{Integer.MAX_VALUE};

        int[] countSmall = new int[]{0};
        inorder(root, countSmall, k, kthSmallest);

        int[] countLarge = new int[]{0};
        reverseInorder(root, countLarge, k, kthLargest);

        return new int[]{kthLargest[0], kthSmallest[0]};
    }

    // Utility to print inorder
    public static void printInorder(Node root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
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

            int k = in.nextInt();
            int[] result = findKthValues(root, k);

            System.out.println("Kth Largest = " + result[0] + ", Kth Smallest = " + result[1]);
        }
    }
}
