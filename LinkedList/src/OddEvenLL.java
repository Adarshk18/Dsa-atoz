import java.util.Scanner;

public class OddEvenLL {
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

    public Node merge(){
        Node oddHead = new Node(-1);
        Node oddTail = oddHead;

        Node evenHead = new Node(-1);
        Node evenTail = evenHead;

        Node p = head;
        Node q;

        while (p!=null){
            q = p;
            p = p.next;
            q.next = null;

            if (q.data%2==1){
                oddTail.next = q;
                oddTail = q;
            }else{
                evenTail.next = q;
                evenTail = q;
            }
        }
        oddTail.next = evenHead.next;
        return oddHead.next;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();
        while (t-->0){
            OddEvenLL list = new OddEvenLL();
            int n = in.nextInt();

            for (int i = 0; i < n; i++) {
                int data = in.nextInt();
                list.create(data);
            }

           list.merge();
            list.display();
        }
    }
}
