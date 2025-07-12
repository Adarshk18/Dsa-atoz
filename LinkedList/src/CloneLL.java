import java.util.*;

public class CloneLL {
    class Node{
        int data;
        Node next;
        Node random;

        Node(){
            this.data = 0;
            this.next = null;
            this.random = null;
        }

        Node(int data){
            this.data = data;
            this.next = null;
            this.random = null;
        }

        Node (int data, Node next, Node random){
            this.data = data;
            this.next = next;
            this.random = random;
        }
    }
    Node head;

    public void create(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }


    public void display(Node head){
        Node temp = head;

        while (temp!=null){
            System.out.print(temp.data + " -> ");
            if (temp.random!=null){
                System.out.print(temp.random.data);
            }else {
                System.out.println("null");
            }
            System.out.println();
            temp = temp.next;
        }

    }

    //inserting in between
    public void insertBetween(Node head){
        Node temp = head;
        while (temp!=null){
            Node copy = new Node(temp.data);
            copy.next = temp.next;
            temp.next = copy;
            temp = temp.next;
        }
    }

    //connecting random
    public void connectingRandom(Node head){
        Node temp = head;
        while (temp!=null){
            Node copy = temp.next;
            if (temp.random!=null){
                copy.random = temp.random.next;
            }else{
                copy.random = null;
            }
            temp = temp.next.next;
        }
    }

    //connectingNext

    public Node connectingNext(Node head){
        Node dummy = new Node(-1);
        Node res = dummy;
        Node temp = head;
        while (temp!=null){
            res.next = temp.next;
            res = res.next;

            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummy.next;
    }

    public Node copyRandomList(Node head) {
    if (head==null) return null;

    insertBetween(head);

    connectingRandom(head);

    return connectingNext(head);
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
            list.display(list.head);
            Node clonedList = list.copyRandomList(list.head);

            list.display(clonedList);
        }
    }
}
