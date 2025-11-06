import java.util.*;

public class DistinctSubsequences {

    public static int function(int i, int j,String s, String t,int[][] dp){

        if (j==0) return 1;
        if (i==0) return  0;

        if (dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i-1)==t.charAt(j-1)){
            return dp[i][j] =  function(i-1,j-1,s,t,dp) + function(i-1,j,s,t,dp);
        }
        return dp[i][j] = function(i-1,j,s,t,dp);
    }

    public static int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n+1][m+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return  function(n,m,s,t,dp);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            String s = in.next();
            String u = in.next();

            int result = numDistinct(s,u);
            System.out.println(result);
        }
    }
}
