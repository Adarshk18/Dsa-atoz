import java.util.*;

public class WildCardMatching {

    public static boolean isAllStars(String s, int i){
        for (int j = 0; j <= i; j++) {
            if (s.charAt(j)!='*'){
                return false;
            }
        }
        return true;
    }

    public static int function(int i, int j, String s, String p, int[][] dp) {

        //Base case

        //if both gets exhausted
        if (i < 0 && j < 0) {
            return 1;
        }

        //if i gets exhausted
        if (i < 0 && j >= 0) {
            return 0;
        }

        //if j gets exhausted
        if (j < 0 && i >= 0) {
            return isAllStars(s,i) ? 1:0;
        }


        if (dp[i][j]!=-1) return dp[i][j];

        if (s.charAt(i) == p.charAt(j) && s.charAt(i) == '?') {
            return dp[i][j] = function(i-1,j-1,s,p,dp);
        }
        else{
            if (s.charAt(i) == '*') {
                return dp[i][j] = (function(i - 1, j, s, p,dp) ==1 || function(i, j - 1, s, p,dp) == 1) ? 1:0;
            }else{
                return 0;
            }

        }

    }

    public static int isMatch(String s, String p) {
        int n = s.length(); int m = p.length();
        int[][] dp = new int[n][m];
        for(int[] row: dp) Arrays.fill(dp,-1);
        return function(n-1,m-1,s,p,dp);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            String s = in.next();
            String u = in.next();


           if (isMatch(s,u)==1){
               System.out.println("true");
           }else{
               System.out.println("false");
           }
        }
    }
}
