import java.util.*;

public class BinaryTreeRepresentation {
    static class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildTree(Scanner in){
        int val = in.nextInt();

        if (val==-1) return null;

        Node newNode = new Node(val);
        System.out.println("Enter the left child of " + val);
        newNode.left = buildTree(in);

        System.out.println("Enter the right child of " + val);
        newNode.right = buildTree(in);

        return newNode;
    }

    public static void Inorder(Node root){
        if (root == null) return;

        Inorder(root.left);
        System.out.print(root.data + " ");
        Inorder(root.right);
    }

    public static void Preorder(Node root){
        if (root == null) return;


        System.out.print(root.data + " ");
        Preorder(root.left);
        Preorder(root.right);
    }

    public static void Postorder(Node root){
        if (root == null) return;

        Postorder(root.left);
        Postorder(root.right);
        System.out.print(root.data + " ");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Node root = buildTree(in);

        System.out.println("\nInorder Traversal:");
        Inorder(root);

        System.out.println("\nPreorder Traversal:");
        Preorder(root);

        System.out.println("\nPostorder Traversal:");
        Postorder(root);
    }
}
