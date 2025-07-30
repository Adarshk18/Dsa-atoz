import java.util.*;

public class LinkedListQueue {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node front=null,rear=null;

    public void enqueue(int val){
        Node newNode = new Node(val);
        if (rear==null){
            front = rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println(val + " enqueued.");
    }

    public void dequeue(){
        if (front==null){
            System.out.println("Queue is empty(underflow).");
            return;
        }
        front = front.next;
        if (front==null) rear = null;

    }

    public void display(){
        if (front==null){
            System.out.println("Nothing to display");
            return;
        }
        Node temp = front;
        while (temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedListQueue ql = new LinkedListQueue();

        while(true){
            System.out.println("\n1. Enqueue\n2. Dequeue\n3. Display\n4. Exit");
            System.out.print("Enter the choice: ");
            int ch = in.nextInt();

            switch (ch){
                case 1:
                    System.out.print("Enter the element to enqueue: ");
                    int val = in.nextInt();
                    ql.enqueue(val);
                    break;
                case 2:
                    ql.dequeue();
                    break;
                case 3:
                    ql.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
