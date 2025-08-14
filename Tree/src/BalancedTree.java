import java.util.*;

public class BalancedTree {
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

    public static boolean isBalanced(Node root) {
        return dfsCheck(root)!=-1;
    }

    public static int dfsCheck(Node root){
        if (root==null) return 0;

        int leftHeight = dfsCheck(root.left);
        if (leftHeight==-1) return -1;
        int rightHeight = dfsCheck(root.right);
        if (rightHeight==-1) return -1;

        if (Math.abs(leftHeight-rightHeight)>1) return -1;
        return Math.max(leftHeight,rightHeight)+1;

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();;

        while (t-->0){
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            Node root = buildTreeFromArray(arr);

            if (isBalanced(root)){
                System.out.println("true");
            }else{
                System.out.println("false");
            }
        }
    }
}
