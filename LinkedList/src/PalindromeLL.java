import java.util.Scanner;

public class PalindromeLL {
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

    public Node reverseLL(Node head){
        if (head==null || head.next==null){
            return head;
        }

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

    public boolean isPalindrome(Node head){
        if (head == null || head.next==null) return true;

        Node slow = head;
        Node fast = head;

        while (fast!=null && fast.next.next!=null){
            slow  = slow.next;
            fast = fast.next.next;
        }

        Node newHead = reverseLL(slow.next);
        Node first = head;
        Node second = newHead;

        while (second!=null){
            if (first.data!=second.data){
                reverseLL(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
       reverseLL(newHead);
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();
        while (t-->0){
            PalindromeLL list = new PalindromeLL();
            int n = in.nextInt();

            for (int i = 0; i < n; i++) {
                int data = in.nextInt();
                list.create(data);
            }

            System.out.println(list.isPalindrome(list.head) ? "true" : "false");
        }
    }
}
