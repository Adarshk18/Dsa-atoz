import java.util.*;

public class ReverseNodesKGroup {
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

    public Node reverse(Node head){
        Node p = head;
        Node prev = null;

        while (p!=null){
            Node front = p.next;
            p.next = prev;
            prev = p;
            p = front;

        }
        return prev;
    }

    public Node getkthPos(Node p, int k){
        k -= 1;
        while (p!=null && k>0){

            p = p.next;
            k--;
        }
        return p;
    }

    public Node kReverse(Node head, int k){
        Node p = head;
        Node prevLast = null;

        while (p!=null){
            Node kthNode = getkthPos(p,k);
            if (kthNode==null){
                if (prevLast!=null){
                    prevLast.next = p;
                }
                break;
            }

            Node nextNode = kthNode.next;
            kthNode.next = null;
            reverse(p);
            if (p==head){
                head = kthNode;
            }else{
                prevLast.next = kthNode;
            }
            prevLast = p;
            p = nextNode;
        }
        return head;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();

        while (t-->0){
            int n = in.nextInt();
            ReverseNodesKGroup list = new ReverseNodesKGroup();
            for (int i = 0; i < n; i++) {
                int data = in.nextInt();
                list.create(data);
            }
            int k = in.nextInt();

            list.head = list.kReverse(list.head, k);
            list.display();
        }
    }
}
