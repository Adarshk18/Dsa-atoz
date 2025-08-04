import java.util.*;

public class QueueUsingArray {
        private int front,rear,size;
        private int capacity;
        private int[] queue;

        QueueUsingArray(int capacity){
           this.capacity= capacity;
           this.front = this.size =0;
           this.rear = capacity-1;
           this.queue = new int[capacity];
        }

        public boolean isFull(){
            return size==capacity;
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public void enqueue(int data){
            if (isFull()){
                System.out.println("Queue is full.");
                return;
            }
            rear = (rear+1)%capacity;
            queue[rear] = data;
            size++;
            System.out.println(data + " enqueued.");
        }

        public int dequeue(){
            if (isEmpty()){
                System.out.println("Queue is empty(Underflow).");
                return Integer.MIN_VALUE;
            }
            int x = queue[front];
            front = (front+1)%capacity;
            size--;
            return x;
        }

        public int peek(){
            if (isEmpty()){
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }
            return queue[front];
        }

        public void display(){
            if (isEmpty()){
                System.out.println("Queue is empty(Underflow).");
                return;
            }
            for (int i = 0; i < size; i++) {
                System.out.print(queue[(front+i)%capacity] + " ");
            }
            System.out.println();
        }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        QueueUsingArray q = new QueueUsingArray(n);

        while(true){
            System.out.println("\n1. Enqueue\n2. Dequeue\n3. Peek\n4. Display\n5. Exit");
            System.out.print("Enter the choice: ");
            int ch = in.nextInt();

            switch (ch){
                case 1:
                    if (q.isFull()){
                        System.out.println("Queue is full");
                    }else{
                        int val = in.nextInt();
                        q.enqueue(val);
                    }
                    break;
                case 2:
                    int dequeued = q.dequeue();
                    if (dequeued!=Integer.MIN_VALUE){
                        System.out.print("Dequeued " + dequeued);
                    }
                    break;
                case 3:
                    int peek = q.front;
                    if (peek!=Integer.MIN_VALUE){
                        System.out.print("Dequeued " + peek);
                    }
                    break;
                case 4:
                    q.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
