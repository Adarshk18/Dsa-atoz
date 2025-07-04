import java.util.*;

// Node class


// LinkedList class
public class MiddleLL {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // Add a node to the end
    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }
    }

    // Display all nodes
    public void display() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public Node middle(Node head){
        Node slow = head;
        Node fast = head;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
       return slow;
    }

    public void print(Node node){
        System.out.print("[");
        while (node!=null){
            System.out.print(node.data);
            if (node.next!=null) System.out.print(",");
            node = node.next;
        }
        System.out.print("]");
        System.out.println();
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0){
            int n = sc.nextInt();

            MiddleLL list = new MiddleLL();
            for (int i = 0; i < n; i++) {
               list.add(sc.nextInt());
            }

            Node middleel = list.middle(list.head);
            list.print(middleel);


            }
        }
}
