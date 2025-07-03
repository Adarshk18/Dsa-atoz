import java.util.*;

public class DisplayDLL {
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
        Node temp = head;

        while (temp!=null){
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        DisplayDLL list = new DisplayDLL();
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int data = in.nextInt();
            list.create(data);
        }

        list.display();
    }
}
