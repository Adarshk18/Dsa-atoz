import java.util.*;

public class BoundaryTraversal {
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

    public static boolean isLeafNode(Node root){
        return root.left==null && root.right==null;
    }
    public static void leftB(Node root, List<Integer> res){
        Node curr = root.left;
        while (curr!=null){
            if (!isLeafNode(curr)){
                res.add(curr.data);
            }

            if (curr.left!=null){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
    }

    public static void rightB(Node root,List<Integer> res){
        Node curr = root.right;
        List<Integer> temp = new ArrayList<>();
        while (curr!=null){
            if (!isLeafNode(curr)){
                temp.add(curr.data);
            }

            if (curr.right!=null){
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }

        for (int i = temp.size()-1; i >= 0; i--) {
            res.add(temp.get(i));
        }
    }

    public static void addLeave(Node root, List<Integer> res){
        if (isLeafNode(root)){
            res.add(root.data);
            return;
        }

        if (root.left!=null){
            addLeave(root.left,res);
        }
        if (root.right!=null){
            addLeave(root.right,res);
        }

    }
    public static List<Integer> printBoundary(Node root){
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;

        if (!isLeafNode(root)){
            res.add(root.data);
        }

        leftB(root,res);
        rightB(root,res);
        addLeave(root,res);

        return res;
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


            Node root = buildTreeFromArray(arr);

            System.out.println(printBoundary(root));
        }
    }
}
