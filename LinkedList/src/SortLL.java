import java.util.*;

public class SortLL {
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

    //The goal is using merge sort which is inplace so first we will find the middle of the list then divide them in smaller parts
    //2. will merge them
    //3.sort them


    public Node findMiddle(Node head){
        if (head==null || head.next==null){
            return head;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node mergeList(Node list1, Node list2){
        Node dummyNode = new Node(-1);
        Node p = dummyNode;

        while (list1!=null && list2!=null){
            if (list1.data < list2.data){
                p.next = list1;
                list1 = list1.next;
            }else{
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }

        if (list1!=null){
            p.next = list1;
        }else{
            p.next = list2;
        }

        return dummyNode.next;
    }

    public Node sortList(Node head){
        if (head==null || head.next==null){
            return  head;
        }

        Node middle = findMiddle(head);
        Node right = middle.next;
        middle.next = null;
        Node left = head;

        left = sortList(left);
        right = sortList(right);

        return mergeList(left,right);
    }

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int t= in.nextInt();

        while (t-->0){
            SortLL list = new SortLL();
            int n = in.nextInt();

            for (int i = 0; i < n; i++) {
                int data = in.nextInt();
                list.create(data);
            }


            list.head = list.sortList(list.head);

            list.display();
        }
    }
}
