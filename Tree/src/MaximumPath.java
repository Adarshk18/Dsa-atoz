import java.util.*;

public class MaximumPath {
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

    public static int findMaxi(Node root, int[] maxi){
        if (root==null) return 0;

        int lh = Math.max(0,findMaxi(root.left,maxi));
        int rh = Math.max(0,findMaxi(root.right,maxi));

        maxi[0] = Math.max(maxi[0],lh+rh+root.data);

        return Math.max(lh,rh) + root.data;

    }

    public static int maxPathSum(Node root) {
        int[] maxi = {Integer.MIN_VALUE};

        findMaxi(root,maxi);
        return maxi[0];
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
            Node sum = buildTreeFromArray(arr);
            System.out.println(maxPathSum(sum));
        }
    }
}
