import java.util.*;


public class FloorCeil {
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

    public static List<Integer> floorCeilOfBST(Node root, int key) {
        //your code goes here
        int floor = -1;
        int ceil = -1;
        Node curr = root;

        while (curr != null) {
            if (curr.data == key) {
                floor = ceil = curr.data;
                break;
            }

            if (curr.data < key) {
                floor = curr.data;
                curr = curr.right;
            } else {
                ceil = curr.data;
                curr = curr.left;
            }

        }
        List<Integer> res = new ArrayList<>();
        res.add(floor);
        res.add(ceil);
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();


        while (t-- > 0) {
            int n = in.nextInt();
            Node root = null;

            for (int i = 0; i < n; i++) {
                int val = in.nextInt();
                root = insertBST(root, val);
            }

            int key = in.nextInt();
            List<Integer> ans = floorCeilOfBST(root, key);
            System.out.println("[" + ans.get(0) + "," + ans.get(1) + "]");
        }
    }
}
