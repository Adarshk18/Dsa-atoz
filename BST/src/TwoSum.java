import java.util.*;

public class TwoSum {
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

    // ---------------- Iterator Class ----------------
    static class BSTIterator {
        private Stack<Node> stack = new Stack<>();
        private boolean reverse;

        BSTIterator(Node root, boolean isReverse) {
            reverse = isReverse;
            pushAll(root);
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public int next() {
            Node temp = stack.pop();
            if (!reverse) pushAll(temp.right);
            else pushAll(temp.left);
            return temp.data;
        }

        private void pushAll(Node node) {
            while (node != null) {
                stack.push(node);
                if (reverse) node = node.right;
                else node = node.left;
            }
        }
    }


    public static boolean findTarget(Node root, int k) {
        if (root == null) return false;

        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        int i = l.next();
        int j = r.next();

        while (i < j) {
            if (i + j == k) return true;
            else if (i + j < k) {
                if (l.hasNext()) i = l.next();
                else return false;
            } else {
                if (r.hasNext()) j = r.next();
                else return false;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node root = null;

        for (int i = 0; i < n; i++) {
            root = insertBST(root, in.nextInt());
        }

        int k = in.nextInt();
        boolean t = findTarget(root, k);

        System.out.println(t ? "true" : "false");
    }
}
