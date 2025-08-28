import java.util.*;

public class DeleteANode {
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

    public static Node DeleteNode(Node root, int key){
        if (root==null) return null;

        if (root.data==key){
            return helper(root);
        }

        Node curr = root;
        while (curr!=null){
            if (curr.data>key){
                if (root.left!=null && root.left.data==key){
                    root.left = helper(root.left);
                    break;
                }else{
                    root = root.left;
                }
            }else{
                if (root.right!=null && root.right.data==key){
                    root.right = helper(root.right);
                    break;
                }else{
                    root = root.right;
                }
            }
        }
        return curr;
    }

    public static Node helper(Node root){
        if (root.left==null){
           return root.right;
        }else if(root.right==null){
            return root.left;
        }else{
            Node rightChild = root.right;
            Node lastRight = findLastRight(root.left);
            lastRight.right = rightChild;
            return root.left;
        }
    }

    public static Node findLastRight(Node root){
        if (root.right==null){
            return root;
        }
        return findLastRight(root.right);
    }

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-->0){
            int n = in.nextInt();
           Node root = null;

            for (int i = 0; i < n; i++) {
                int val = in.nextInt();
                root = insertBST(root,val);
            }

            int key = in.nextInt();
            root = DeleteNode(root,key);

            inorder(root);
            System.out.println();

        }
    }
}
