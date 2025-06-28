import java.util.*;

public class BracketReversal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());

        while (t-->0){
            String s = in.nextLine();
            int open = 0;
            int unmatched = 0;

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch=='('){
                    open++;
                } else if (ch == ')') {
                    if (open>0){
                        open--;
                    }else{
                        unmatched++;
                    }
                }
            }
            System.out.println(open+unmatched);
        }
    }
}
