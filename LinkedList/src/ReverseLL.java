import java.util.*;

// Node class


// LinkedList class
public class ReverseLL {
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
    public void display(Node head) {
        Node current = head;

        System.out.print("[");
        while (current != null) {
            System.out.print(current.data);
            if (current.next!=null) System.out.print(",");
            current = current.next;
        }
        System.out.print("]");

        System.out.println();
    }

    public Node reverse(Node head){
        Node p = head;
        Node prev = null;

        while (p!=null){
            Node front = p.next;

            p.next = prev;
            prev = p;

            p = front;
        }
        return prev;
    }




    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0){

            ReverseLL list = new ReverseLL();int n = sc.nextInt();


            for (int i = 0; i < n; i++) {
                list.add(sc.nextInt());
            }

            list.head = list.reverse(list.head);
            list.display(list.head);


        }
    }
}
