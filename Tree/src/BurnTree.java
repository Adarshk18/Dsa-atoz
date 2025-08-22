import java.util.*;

public class BurnTree {
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

    public static Node markParent(Node root, Map<Node,Node> parent_node, int target){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node targetNode = null;

        while (!q.isEmpty()){
            Node curr = q.poll();
            if (curr.data==target) targetNode = curr;

            if (curr.left!=null){
                parent_node.put(curr.left,curr);
                q.add(curr.left);
            }

            if (curr.right!=null){
                parent_node.put(curr.right,curr);
                q.add(curr.right);
            }
        }
        return targetNode;
    }

    public static int burnTree(Node root, int target){
        Map<Node,Node> parent_node = new HashMap<>();
        Node targetNode = markParent(root,parent_node,target);
        Map<Node,Boolean> vis = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(targetNode);
        vis.put(targetNode,true);

        int time =0;
        while (!q.isEmpty()){
            int n= q.size();
            boolean burned = false;

            for (int i = 0; i < n; i++) {
                Node curr = q.poll();
                if (curr.left!=null && !vis.containsKey(curr.left)){
                    burned = true;
                    vis.put(curr.left,true);
                    q.add(curr.left);
                }
                if (curr.right!=null && !vis.containsKey(curr.right)){
                    burned = true;
                    vis.put(curr.right,true);
                    q.add(curr.right);
                }

                if (parent_node.containsKey(curr) && !vis.containsKey(parent_node.get(curr))){
                    burned = true;
                    vis.put(parent_node.get(curr),true);
                    q.add(parent_node.get(curr));
                }
            }
            if (burned) time++;
        }
        return time;
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

            int target = in.nextInt();
            Node root = buildTreeFromArray(arr);
            System.out.println(burnTree(root,target));

        }
    }
}
