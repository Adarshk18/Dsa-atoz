import java.util.*;

public class ZigZag {
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

    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root==null){
            return result;
        }

        boolean leftToRight = true;
        Queue<Node> q  = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            int n = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                Node node = q.poll();

                if (leftToRight){
                    level.add(node.data);
                }else{
                    level.add(0,node.data);
                }

                if (node.left!=null){
                    q.add(node.left);
                }
                if (node.right!=null){
                    q.add(node.right);
                }
            }
            leftToRight = !leftToRight;
            result.add(level);

        }
        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();;

        while (t-->0) {
            int n1 = in.nextInt();
            int[] arr = new int[n1];
            for (int i = 0; i < n1; i++) {
                arr[i] = in.nextInt();
            }

            Node node = buildTreeFromArray(arr);
            List<List<Integer>> res = new ArrayList<>();
            System.out.println(zigzagLevelOrder(node));
        }
    }
}
