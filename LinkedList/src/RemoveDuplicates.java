import java.util.*;



// LinkedList class
public class RemoveDuplicates {

    private class Node {
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


    public void Remove(){

        Node p = head;
        Node q = head.next;

        while (q!=null){
            if (p.data!=q.data){
                p = q;
                q = q.next;
            }else{
                p.next = q.next;
                q = p.next;
            }

        }
    }



    public static void main(String[] args) {
        RemoveDuplicates list = new RemoveDuplicates();
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print(i + ": ");
            int data = sc.nextInt();
            list.add(data);
        }

        list.display();

        list.Remove();
        list.display();
        sc.close();
    }
}
