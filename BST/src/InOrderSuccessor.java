import java.util.*;

public class InOrderSuccessor {
    static class Node {
        int data;
        Node left, right;

        Node(int val) {
            data = val;
            left = right = null;
        }
    }

    static Node insertBST(Node root, int key) {
        if (root == null) return new Node(key);
        if (key < root.data) root.left = insertBST(root.left, key);
        else root.right = insertBST(root.right, key);
        return root;
    }

    static List<Integer> succPredBST(Node root, int key) {
        //your code goes here
        Node successor = null, predecessor = null;
        Node curr = root;

        while (curr!=null){
            if (key<curr.data){
                successor = curr;
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }

        curr = root;
        while (curr!=null){
            if (key>curr.data){
                predecessor = curr;
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(predecessor!=null ? predecessor.data:-1);
        res.add(successor!=null ? successor.data:-1);
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-->0){
            int n = in.nextInt();
            Node root = null;
            for (int i = 0; i < n; i++) {
                root = insertBST(root,in.nextInt());
            }

            int key = in.nextInt();
            List<Integer> res = succPredBST(root,key);
            System.out.println(res);
        }
    }
}
