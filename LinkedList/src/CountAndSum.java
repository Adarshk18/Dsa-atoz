import java.util.*;


// LinkedList class
public class CountAndSum {
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

    public static void countSum(Node head){

        int cnt =0;
        int sum =0;
        Node p = head;
        while (p!=null){
            cnt++;
            sum += p.data;
            p = p.next;
        }
        System.out.println(cnt + " " + sum);;
    }




    public static void main(String[] args) {
        CountAndSum list = new CountAndSum();
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print(i + ": ");
            int data = sc.nextInt();
            list.add(data);
        }

        list.display();
        countSum(list.head);
        sc.close();
    }
}
