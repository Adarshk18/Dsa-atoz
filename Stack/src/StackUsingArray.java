import java.util.*;

//using array

public class StackUsingArray {
   private int maxSize;
   private int[] stackArray;
   private int top;

   StackUsingArray(int size){
       maxSize = size;
       stackArray = new int[maxSize];
       top = -1;
   }

   public void push(int val){
       if (top==maxSize-1){
           System.out.println("Stack Overflow");
           return;
       }
       stackArray[++top] = val;
       System.out.println(val);
   }

   public int peek(){
       if (isEmpty()){
           System.out.println("Stack is empty.");
           return -1;
       }
       return stackArray[top];
   }

   public int pop(){
       if (isEmpty()){
           System.out.println("Stack Underflow");
           return -1;
       }
       return stackArray[top--];
   }

   public boolean isEmpty(){
       return (top==-1);
   }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        StackUsingArray st = new StackUsingArray(n);
        while (true){
            int choice = in.nextInt();

            switch (choice){
                case 1:
                    int val = in.nextInt();
                    st.push(val);
                    break;
                case 2:
                    int popped = st.pop();
                    if (popped==-1){
                        System.out.println(popped);
                    }
                    break;
                case 3:
                    int top = st.peek();
                    if (top==1){
                        System.out.println(top);
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Wrong input");
            }
        }
    }
}
