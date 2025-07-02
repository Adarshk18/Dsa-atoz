import java.util.*;


public class DisplayCLL {
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data =data;
            this.next = null;
        }
    }

    Node head = null;

    public void create(int data){
        Node newNode = new Node(data);

        if (head==null){
            head = newNode;
            newNode.next = head;
        }else{
            Node temp = head;

            while (temp.next!=head){
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.next = head;
        }
    }

    public void display(){
        if (head==null){
            return;
        }

        Node temp = head;
        do{
            System.out.println(temp.data + " -> ");
            temp = temp.next;
        }while (temp!=head);

        System.out.println("(head)");
    }

    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    DisplayCLL cll = new DisplayCLL();

    int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int data = in.nextInt();
            cll.create(data);
        }

        cll.display();
    }
}
