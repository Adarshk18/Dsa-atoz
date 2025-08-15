import java.util.*;

public class SameTree {
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

    public static boolean isSameTree(Node p, Node q) {
        if (p==null && q==null){
            return true;
        }

        if (p==null || q==null){
            return false;
        }

        return (p.data==q.data) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
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
            int n2 = in.nextInt();
            int[] arr2 = new int[n2];
            for (int i = 0; i < n2; i++) {
                arr2[i] = in.nextInt();
            }

            Node arr1 = buildTreeFromArray(arr);
            Node arr3 = buildTreeFromArray(arr2);
            System.out.println(isSameTree(arr1,arr3));
        }
    }
}
