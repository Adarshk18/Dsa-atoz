import java.util.*;

public class IterativeProrder {
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

    public static List<Integer> preorderTraversal(Node root) {
        List<Integer> preOrder = new ArrayList<Integer>();
        if (root==null) return preOrder;
        Stack<Node> st = new Stack<Node>();
        st.push(root);

        while (!st.isEmpty()){
            root = st.pop();
            preOrder.add(root.data);

            if (root.left!=null) st.push(root.left);

            if (root.right!=null) st.push(root.right);
        }
        return preOrder;
    }

    public static List<Integer> inOrderTraversal(Node root) {
        List<Integer> inOrder = new ArrayList<Integer>();
        Stack<Node> st = new Stack<Node>();
        Node node = root;

        while (true){
           if (node!=null){
               st.push(node);
               node = node.left;
           }else{
               while (st.isEmpty()){
                   break;
               }
               node = st.pop();
               inOrder.add(node.data);
               node = node.right;
           }
           return inOrder;
        }

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-->0){
            Node root = buildTree(in);

            System.out.println("\nPreorder Traversal");
            System.out.print(preorderTraversal(root));

            System.out.println("\nInorder Traversal");
            System.out.print(inOrderTraversal(root));

            System.out.println();
        }
        in.close();

    }
}
