import java.util.*;

public class IntersectionLL {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Heads of both linked lists
    Node head1 = null;
    Node head2 = null;

    // Append node to a given list
    public Node insert(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) return newNode;

        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        return head;
    }

    // Display method
    public void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Returns intersection node or null
    public Node getIntersectionNode(Node headA, Node headB) {
        Node a = headA;
        Node b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        IntersectionLL list = new IntersectionLL();

        // First list
        int n1 = in.nextInt();
        for (int i = 0; i < n1; i++) {
            int val = in.nextInt();
            list.head1 = list.insert(list.head1, val);
        }

        // Second list
        int n2 = in.nextInt();
        for (int i = 0; i < n2; i++) {
            int val = in.nextInt();
            list.head2 = list.insert(list.head2, val);
        }

        // Intersect both lists at k-th node of first list
        int k = in.nextInt(); // intersection position (1-based index)
        if (k <= n1) {
            Node temp1 = list.head1;
            while (--k > 0 && temp1 != null) temp1 = temp1.next;

            // Move to end of second list and attach
            Node temp2 = list.head2;
            while (temp2 != null && temp2.next != null) temp2 = temp2.next;

            if (temp2 != null) temp2.next = temp1; // intersect
        }


        list.display(list.head1);

        list.display(list.head2);

        Node intersection = list.getIntersectionNode(list.head1, list.head2);
        if (intersection != null) {
            System.out.println("Intersection at node with value: " + intersection.data);
        } else {
            System.out.println("No intersection");
        }
    }
}
