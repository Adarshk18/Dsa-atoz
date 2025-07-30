import java.util.*;

public class QueueUsingArray {
        int front,rear,capacity;
        int[] queue;

        QueueUsingArray(int size){
            front = rear = -1;
            capacity = size;
            queue = new int[size];
        }

        public void enqueue(int data){
            if (front==capacity-1){
                System.out.println("Queue is full.");
                return;
            }
            if (front==-1) front=0;

            queue[++rear] = data;
            System.out.println(data + " enqueued.");
        }

        public void dequeue(){
            if (front==-1 || front>rear){
                System.out.println("Queue is empty(Underflow).");
                return;
            }

            System.out.println(queue[front++]+ " dequeued.");
        }

        public void display(){
            if (front==-1 || front>rear){
                System.out.println("Queue is empty(Underflow).");
                return;
            }
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        QueueUsingArray q = new QueueUsingArray(n);

        while(true){
            System.out.println("\n1. Enqueue\n2. Dequeue\n3. Display\n4. Exit");
            System.out.print("Enter the choice: ");
            int ch = in.nextInt();

            switch (ch){
                case 1:
                    System.out.print("Enter the element to enqueue: ");
                    int val = in.nextInt();
                    q.enqueue(val);
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    q.display();
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
