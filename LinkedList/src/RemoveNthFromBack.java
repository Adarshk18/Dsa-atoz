import java.util.Scanner;

public class RemoveNthFromBack {
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
        System.out.println();
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

    public Node deleteNode(Node head, int n){
        Node dummy = new Node(0);
        dummy.next = head;

        Node fast = dummy;
        Node slow = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }


        while (fast!=null){
            slow = slow.next;
            fast = fast.next;
        }


        slow.next=slow.next.next;

        return dummy.next;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-->0){
            RemoveNthFromBack list = new RemoveNthFromBack();
            int n = in.nextInt();


            for (int i=0; i<n; i++){
                list.create(in.nextInt());
            }
            int N = in.nextInt();

            list.head = list.deleteNode(list.head, N);
            list.display();
        }
    }
}
