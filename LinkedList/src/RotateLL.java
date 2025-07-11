import java.util.*;

public class RotateLL {
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

    public Node rotateList(Node head, int k){
        if (head==null || head.next==null || k==0){
            return head;
        }

        Node p = head;
        int length = 1;
        while (p.next!=null){
            length++;
            p = p.next;
        }
        p.next = head;
        k %= length;
        int end = length - k;
        while (end--!=0) p = p.next;
        head = p.next;
        p.next = null;
        return head;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t= in.nextInt();
        while (t-->0){
            RotateLL list = new RotateLL();
            int n = in.nextInt();

            for (int i = 0; i < n; i++) {
                int data = in.nextInt();
                list.create(data);
            }

            int k = in.nextInt();
            list.head = list.rotateList(list.head,k);
            list.display();
        }
    }
}
