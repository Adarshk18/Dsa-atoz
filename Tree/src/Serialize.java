import java.util.*;

public class Serialize {
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

    public String serialize(Node root) {
        if (root==null) return "";

        Queue<Node> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()){
            Node node = q.poll();

            if (node==null){
                sb.append("null ");
                continue;
            }
            sb.append(node.data+ " ");
            q.add(node.left);
            q.add(node.right);
        }
        return sb.toString().trim();
    }

    public Node deserialize(String data) {
        if (data.isEmpty()) return null;

        Queue<Node> q = new LinkedList<>();
        String[] values = data.trim().split(" ");
        Node root = new Node(Integer.parseInt(values[0]));
        q.add(root);
        int i=1;
        while (!q.isEmpty() && i< values.length) {
            Node parent = q.poll();

            if (!values[i].equals("null")){
                Node left = new Node(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            i++;

            if (i< values.length && !values[i].equals("null")){
                Node right = new Node(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
            i++;
        }
        return root;
    }

    public void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        Serialize ser = new Serialize();

        while (t-->0){
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            Node root = buildTreeFromArray(arr);

            String serialized = ser.serialize(root);
            System.out.println("Serialized: " + serialized);

            Node deserialized = ser.deserialize(serialized);
            ser.inorder(deserialized);
            System.out.println();
        }
    }
}
