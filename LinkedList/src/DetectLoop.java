import java.util.*;

public class DetectLoop {
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
            Node current = head;

            while (current.next!=null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void display(){
        Node temp = head;
        int cnt =0;
        while (temp!=null){
            System.out.println(temp.data + " -> ");
            temp = temp.next;
            cnt++;
        }
        System.out.println("null");
    }

    public boolean hasCycle(Node head){
        Node slow = head;
        Node fast = head;

        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow==fast){
                return true;
            }
        }
        return false;
    }

    public void createCycle(int pos){
        if (pos==-1) return;

        Node tail = head;
        Node newNode = null;
        int indx = 0;

        while (tail.next!=null){
            if (indx==pos) newNode = tail;
            tail = tail.next;
            indx++;
        }
        tail.next = newNode;
    }

    public static void main(String[] args) {
        DetectLoop list = new DetectLoop();
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-->0){
            int n = in.nextInt();
            int pos = in.nextInt();


            for (int i = 0; i < n; i++) {
                int data = in.nextInt();
                list.create(data);
            }
            list.createCycle(pos);
        }


        System.out.println(list.hasCycle(list.head) ? "YES": "NO");
    }
}
