import java.io.*;
import java.util.*;

public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        gen(result,"",0,0,n);
        return result;
    }

    private static void gen(List<String> result, String current, int open, int close, int max){
        if (current.length()==max*2){
            result.add(current);
            return;
        }

        if (open<max){
            gen(result,current+'(',open+1,close,max);
        }

        if (close<open){
            gen(result,current+')',open, close+1,max);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t= Integer.parseInt(in.nextLine());

        while(t-->0){
            int n = in.nextInt();
            System.out.println(generateParenthesis(n));
        }
    }
}
