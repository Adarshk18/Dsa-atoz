import java.util.*;

public class RightView {
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

    public static List<Integer> rightSideView(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            Node lastNode = null;
            for (int i = 0; i < n; i++) {
                Node node = q.poll();
                lastNode = node;

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }

            }
            if (lastNode != null) res.add(lastNode.data);

        }
        return res;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        ;

        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            Node root = buildTreeFromArray(arr);
            List<Integer> res = rightSideView(root);
            for(int val: res){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
