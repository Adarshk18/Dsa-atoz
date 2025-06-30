import java.util.*;



// LinkedList class
public class Insertion {

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


    public void insertion(int pos, int x){
        Node t;
        Node p;

        if (pos==0){
            t = new Node(x);
            t.next = head;
            head = t;
        }else if(pos>0){
            p = head;
            for (int i = 0; i < pos-1 && p!=null; i++) {
                p = p.next;
            }
            if (p!=null){
                t = new Node(x);
                t.next = p.next;
                p.next = t;
            }
        }
    }



    public static void main(String[] args) {
        Insertion list = new Insertion();
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print(i + ": ");
            int data = sc.nextInt();
            list.add(data);
        }

        list.display();

        int pos = sc.nextInt();
        int val = sc.nextInt();

        list.insertion(pos,val);
        list.display();
        sc.close();
    }
}
