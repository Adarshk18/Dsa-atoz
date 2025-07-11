import java.util.*;

public class CloneLL {
    class Node{
        int data;
        Node next;

        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node head;

    public void create(int data){
        Node newNode = new Node(data);

        if (head==null){
            head = newNode;
        }else{
            Node temp = head;
            while (temp.next!=null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void display(){
        Node temp = head;

        while (temp!=null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t= in.nextInt();
        while (t-->0){
            CloneLL list = new CloneLL();
            int n = in.nextInt();

            for (int i = 0; i < n; i++) {
                int data = in.nextInt();
                list.create(data);
            }


            list.display();
        }
    }
}
