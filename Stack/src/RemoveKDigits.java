import java.util.*;

public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (!st.isEmpty() && k >0 && st.peek() > num.charAt(i)){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while (k >0 && !st.isEmpty()) {
            st.pop();
            k--;

        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()){
            sb.insert(0,st.pop());
        }

        //remove l;eading zeros
        int i=0;
        while (i<sb.length() && sb.charAt(i)=='0'){
            i++;
        }

        String res = sb.substring(i);
       return res.isEmpty() ? "0" : res;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();

        while (t-->0){
            String num = in.next();
            int k = in.nextInt();

            System.out.println(removeKdigits(num,k));
        }
    }
}
