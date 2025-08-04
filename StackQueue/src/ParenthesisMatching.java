import java.util.*;

public class ParenthesisMatching {

    public static boolean isBalanced(String exp){
        Stack<Character> st = new Stack<>();

        for (char ch: exp.toCharArray()){
            if (ch == '(' || ch=='{' || ch=='['){
                st.push(ch);
            }else if(ch == ')' || ch=='}' || ch==']'){
                if (st.isEmpty()) return false;

                char top = st.pop();
                if (!isMatching(top,ch)) return false;
            }
        }
        return st.isEmpty();
    }

    public static boolean isMatching(char open, char close){
        return (open == '(' && close == ')') || (open =='{' && close=='}') || (open=='[' && close==']');
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        if (isBalanced(input)){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }
}
