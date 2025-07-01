import java.util.*;



// LinkedList class
public class Deletion {

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


    public int deletion(int pos){
        Node q;
        Node p; int x=-1;

        if (pos <= 0 || head == null) {
            return -1;
        }

        if (pos==1){
            x = head.data;
            p = head;
            head = head.next;

        }else{
            p = head;
            q = null;
            for (int i = 0; i < pos-1 && p!=null; i++) {
                q=p;
                p = p.next;
            }
            if (p!=null){
                q.next = p.next;
                x = p.data;

            }
        }
        return x;
    }



    public static void main(String[] args) {
        Deletion list = new Deletion();
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print(i + ": ");
            int data = sc.nextInt();
            list.add(data);
        }

        list.display();

        int pos = sc.nextInt();




        list.deletion(pos);
        list.display();
        sc.close();
    }
}
