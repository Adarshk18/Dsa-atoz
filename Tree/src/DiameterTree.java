import java.util.*;

public class DiameterTree {
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

    public static int diameterOfBinaryTree(Node root) {
        int[] diameter = new int[1];
        height(root,diameter);
        return diameter[0];
    }

    public static int height(Node root, int[] diameter){
        if (root == null) return 0;

        int lh = height(root.left,diameter);
        int rh = height(root.right,diameter);

        diameter[0] = Math.max(diameter[0],lh+rh);
        return 1+Math.max(lh,rh);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();;

        while (t-->0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            Node diameter = buildTreeFromArray(arr);
            System.out.println(diameterOfBinaryTree(diameter));
        }
    }
}
