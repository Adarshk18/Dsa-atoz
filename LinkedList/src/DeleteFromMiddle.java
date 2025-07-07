import java.util.*;

public class DeleteFromMiddle {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void display(){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

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

    public Node deleteMiddle(Node head){
        if (head==null || head.next==null){
            return null;
        }

        Node slow = head;
        Node fast = head;
        Node prev = null;


        while (fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

       prev.next = slow.next;
        return head;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-->0){
            DeleteFromMiddle list = new DeleteFromMiddle();
            int n = in.nextInt();


            for (int i=0; i<n; i++){
                list.create(in.nextInt());
            }


            list.head = list.deleteMiddle(list.head);
            list.display();
        }
    }
}
