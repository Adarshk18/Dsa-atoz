import java.util.*;

public class kNodes {
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

    public static void  markParent(Node root, Map<Node,Node> parent_track,Node target){
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        while (!q.isEmpty()){
            Node curr = q.poll();
            if (curr.left!=null){
                parent_track.put(curr.left,curr);
                q.add(curr.left);
            }

            if (curr.right!=null){
                parent_track.put(curr.right,curr);
                q.add(curr.right);
            }
        }
    }

    public static List<Integer> distanceK(Node root, Node target, int k) {
        Map<Node,Node> parent_track = new HashMap<>();
        markParent(root,parent_track,root);
        Map<Node,Boolean> vis = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(target);
        vis.put(target,true);
        int curr_level = 0;

        while (!q.isEmpty()){
            int n= q.size();
            if (curr_level==k) break;
            curr_level++;

            for (int i = 0; i < n; i++) {
                Node curr = q.poll();
                if (curr.left!=null && vis.get(curr.left)==null){
                    q.add(curr.left);
                    vis.put(curr.left,true);
                }

                if (curr.right!=null && vis.get(curr.right)==null){
                    q.add(curr.right);
                    vis.put(curr.right,true);
                }

                if (parent_track.get(curr)!=null && vis.get(parent_track.get(curr))==null){
                    q.add(parent_track.get(curr));
                    vis.put(parent_track.get(curr),true);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()){
            Node curr = q.poll();
            res.add(curr.data);
        }
        return res;
    }

    public static Node findNode(Node root, int target){
        if (root==null) return null;
        if (root.data==target) return root;
        Node left = root.left;
        if (left!=null) return left;
        return findNode(root.right,target);
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
            int k = in.nextInt();

            Node root = buildTreeFromArray(arr);
            Node targetNode = findNode(root,target);
            if (targetNode == null) {
                System.out.println("[]");
            } else {
                List<Integer> list = distanceK(root, targetNode, k);
                System.out.println(list);
            }

        }
    }
}
