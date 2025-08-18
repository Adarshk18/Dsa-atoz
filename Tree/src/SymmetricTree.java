import java.util.*;

public class SymmetricTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildTreeFromArray(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) return null;

        Node root = new Node(arr[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;

        while (!q.isEmpty() && i < arr.length) {
            Node curr = q.poll();

            // Left child
            if (arr[i] != -1) {
                curr.left = new Node(arr[i]);
                q.add(curr.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != -1) {
                curr.right = new Node(arr[i]);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    public static boolean isSymmetricUtil(Node root1, Node root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }

        return (root1.data == root2.data) && isSymmetricUtil(root1.left, root2.right) && isSymmetricUtil(root1.right, root2.left);
    }

    public static boolean isSymmetric(Node root) {
        if (root == null) return true;

        return isSymmetricUtil(root.left, root.right);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();


        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            Node root = buildTreeFromArray(arr);
            boolean res = isSymmetric(root);

            System.out.println(res ? "true" : "false");
        }
    }
}

