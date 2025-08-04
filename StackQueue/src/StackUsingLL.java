import java.util.*;

public class StackUsingLL {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class Stack{
        Node top;

        Stack(){
            this.top = null;
        }

        //push
        public void push(int data){
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
            System.out.println(data);
        }

        //pop
        public void pop(){
            if (isEmpty()){
                System.out.println("Stack underflow");
                return;
            }
            System.out.println(top.data + "popped from the stack");
            top = top.next;
        }

        //peek
        public void peek(){
            if (isEmpty()){
                System.out.println("Stack is empty");
                return;
            }
            System.out.println(top.data);
        }

        public void display(){
            if (isEmpty()){
                System.out.println("Stack empty");
                return;
            }
            Node temp = top;
            while (temp!=null){
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }

        public boolean isEmpty(){
            return top==null;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack st = new Stack();
        int choice;

        do{
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Enter value to push: ");
                    int value = in.nextInt();
                    st.push(value);
                    break;
                case 2:
                    st.pop();
                    break;
                case 3:
                    st.peek();
                    break;
                case 4:
                    st.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("wrong input");
            }
        }while (choice!=5);
    }
}
