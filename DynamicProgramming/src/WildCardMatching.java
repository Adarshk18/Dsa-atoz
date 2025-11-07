import java.util.*;

public class WildCardMatching {

    public static boolean function(int i, int j, String s, String p) {

        //Base case

        //if both gets exhausted
        if (i < 0 && j < 0) {
            return true;
        }

        //if i gets exhausted
        if (i < 0 && j >= 0) {
            return false;
        }

        //if j gets exhausted
        if (j < 0 && i >= 0) {
            for (int k = 0; k <= i; k++) {
                if (s.charAt(k) != '*') return false;

            }
            return true;
        }

        if (s.charAt(i) == p.charAt(j) && s.charAt(i) == '?') {
            return function(i - 1, j - 1, s, p);
        }

        if (s.charAt(i) == '*') {
            return function(i - 1, j, s, p) || function(i, j - 1, s, p);
        }
        return false;
    }

    public static boolean isMatch(String s, String p) {
        int n = s.length(); int m = p.length();
        return function(n-1,m-1,s,p);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            String s = in.next();
            String u = in.next();

           boolean res = isMatch(s,u);
           if (res){
               System.out.println("true");
           }else{
               System.out.println("false");
           }
        }
    }
}
