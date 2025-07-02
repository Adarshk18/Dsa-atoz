import java.util.*;



// LinkedList class
public class MergeTwo {

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // Add a node to the end
    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }
    }

    // Display all nodes
    public void display() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }


   public static MergeTwo merge(MergeTwo list1, MergeTwo list2){

        Node head = list1.head;
        Node second = list2.head;

        Node third;
        Node last;

        if (head.data<second.data){
            third = last = head;
            head = head.next;
            last.next = null;
        }else{
            third = last = second;
            second = second.next;
            last.next = null;
        }

        while (head!=null && second!=null){
            if (head.data<second.data){
                last.next = head;
                last = head;
                head = head.next;
                last.next = null;
            }else{
                last.next = second;
                last = second;
                second = second.next;
                last.next = null;
            }
        }

        if (head!=null){
            last.next = head;

        }else{
            last.next = second;
        }

        MergeTwo mergedList = new MergeTwo();
        mergedList.head = third;
        return mergedList;

   }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MergeTwo list1 = new MergeTwo();
        MergeTwo list2 = new MergeTwo();


        int n1 = sc.nextInt();
        for (int i = 0; i < n1; i++) {
            list1.add(sc.nextInt());
        }

        int n2 = sc.nextInt();
        for (int i = 0; i < n2; i++) {
            list2.add(sc.nextInt());
        }



        list1.display();
        list2.display();

        MergeTwo mergedList = merge(list1,list2);
        mergedList.display();
        sc.close();
    }
}
