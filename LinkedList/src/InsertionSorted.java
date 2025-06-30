import java.util.*;



// LinkedList class
public class InsertionSorted {

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


    public void insertionSorted(int x){

        Node t; Node q;
        Node p = head;
        q = null;

        while (p!=null && p.data<x){
            q = p;
            p = p.next;
        }
        t = new Node(x);
        t.next = q.next;
        q.next = t;
    }



    public static void main(String[] args) {
        InsertionSorted list = new InsertionSorted();
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print(i + ": ");
            int data = sc.nextInt();
            list.add(data);
        }

        list.display();


        int val = sc.nextInt();

       list.insertionSorted(val);
        list.display();
        sc.close();
    }
}
