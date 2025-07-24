import java.util.*;

public class InfixPostfix {

    static boolean isOperand(char ch){
        return !(ch== '+' || ch=='-' || ch=='*' || ch=='/');
    }

    static int precedence(char op){
        switch (op){
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
        }
        return 0;
    }

    static String convertToPostfix(String infix){
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            if (isOperand(ch)){
                postfix.append(ch);
            }else{
                while (!stack.isEmpty() && precedence(ch)<= precedence(stack.peek())){
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()){
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String infix = in.nextLine().replaceAll("\\s","");

        String postfix = convertToPostfix(infix);
        System.out.println(postfix);
    }
}
