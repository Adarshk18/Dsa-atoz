import java.util.*;

public class totalNodes {
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

    public static int findLeftHeight(Node node){
        int height = 0;
        while (node!=null){
            height++;
            node = node.left;
        }
        return height;
    }

    public static int findRightHeight(Node node){
        int height = 0;
        while (node!=null){
            height++;
            node = node.right;
        }
        return height;
    }

    public static int countNodes(Node root){
        if (root==null) return 0;

        int lh = findLeftHeight(root);
        int rh = findRightHeight(root);

        if (lh==rh){
            return (1<<lh)-1;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
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
            int total = countNodes(root);
            System.out.println(total);

        }
    }
}
