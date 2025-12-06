import java.util.*;

public class EvaluateBoolean {
    public static boolean parseBoolExpr(String expression) {
        Stack<Character> st  = new Stack<>();

        for(char c: expression.toCharArray()){
            if (c==',') continue;

            if (c!=')'){
                st.push(c);
            }else{
                int tCount =0, fCount=0;
                while (st.peek()!='('){
                    char x = st.pop();
                    if (x=='t') tCount++;
                    if (x=='f') fCount++;
                }
                st.pop();

                char op = st.pop();

                if (op=='!'){
                    st.push(fCount==1 ? 't':'f');
                }else if (op=='&'){
                    st.push(fCount==0 ? 't':'f');
                }else{
                    st.push(tCount>0?'t':'f');
                }
            }
        }
        return st.pop() == 't';
    }
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());

        while (t-->0){
            String exp = in.nextLine().trim();
            boolean res = parseBoolExpr(exp);
            System.out.println(res);

        }
    }
}
