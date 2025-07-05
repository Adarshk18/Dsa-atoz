import java.util.*;

public class StartingPoint {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void create(int data) {
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

    public Node hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                Node entry = head;
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            }
        }

        return null; // No cycle
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); // Number of test cases

        while (t-- > 0) {
            StartingPoint list = new StartingPoint(); // ✅ Fresh object per test case

            int n = in.nextInt(); // Number of nodes
            for (int i = 0; i < n; i++) {
                int data = in.nextInt();
                list.create(data);
            }

            int pos = in.nextInt(); // Position to create cycle (0-indexed)
            if (pos != -1) {
                Node tail = list.head;
                Node cycleNode = null;
                int index = 0;

                while (tail.next != null) {
                    if (index == pos) cycleNode = tail;
                    tail = tail.next;
                    index++;
                }

                if (index == pos) cycleNode = tail;
                tail.next = cycleNode;
            }

            Node result = list.hasCycle(list.head);
            if (result != null)
                System.out.println("tail connects to node index " + result.data);
            else
                System.out.println("No cycle");
        }
    }
}
