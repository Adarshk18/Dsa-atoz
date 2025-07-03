import java.util.*;

public class InsertionDLL {

    class Node{
        Node prev;
        int data;
        Node next;

        Node(int data){
            this.prev = null;
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;

    public void create(int data){
        Node newNode = new Node(data);

        if (head==null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void display(){
        Node temp =   head;
        while (temp!=null){
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void insert(int pos, int x){
        Node p;
        Node t;

        if (pos==0){
            t = new Node(x);
            t.prev = null;
            t.next = head;
            head.prev = t;
            head = t;
        }else{
            p =head;
            t = new Node(x);
            for (int i = 0; i < pos-1; i++) {
                p = p.next;
            }
            t.next = p.next;
            t.prev = p;

            if (p.next!=null) p.next.prev = t;

            p.next = t;
        }
    }
    public static void main(String[] args) {
        InsertionDLL list = new InsertionDLL();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int data = in.nextInt();
            list.create(data);
        }

        list.display();

        int pos = in.nextInt();
        int x = in.nextInt();

        list.insert(pos,x);
        list.display();
    }
}
