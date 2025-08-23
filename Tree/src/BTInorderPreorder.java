import java.util.*;

public class BTInorderPreorder {
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

    public static Node buildTree(int[] preOrder, int[] inOrder){
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }

        Node root = buildTree2(preOrder,0, preOrder.length-1,inOrder,0,inOrder.length-1,map);

        return root;
    }

    public static Node buildTree2(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd,Map<Integer,Integer> map){
        if (preStart>preEnd || inStart>inEnd) return null;

        Node root = new Node(preOrder[preStart]);

        int inRoot = map.get(root.data);
        int numsLeft = inRoot-inStart;

        root.left = buildTree2(preOrder,preStart+1,preStart+numsLeft,inOrder,inStart,inRoot-1,map);
        root.right = buildTree2(preOrder,preStart+numsLeft+1,preEnd,inOrder,inRoot+1,inEnd,map);

        return root;
    }

    private void printInorder(Node root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        }
    }

    private void printVector(Vector<Integer> vec) {
        for (int i = 0; i < vec.size(); i++) {
            System.out.print(vec.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int[] preOrder = new int[n];
            int[] inOrder = new int[n];

            for (int i = 0; i < n; i++) {
                preOrder[i] = in.nextInt();
            }

            for (int i = 0; i < n; i++) {
                inOrder[i] = in.nextInt();
            }
            Node root = buildTree(preOrder,inOrder);

            BTInorderPreorder bt = new BTInorderPreorder();
            bt.printInorder(root);
            System.out.println();
        }
    }
}
