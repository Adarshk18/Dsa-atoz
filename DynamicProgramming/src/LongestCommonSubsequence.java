import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int  m = text2.length();

        int[][] dp = new int[n+1][m+1];

        for(int[] row: dp){
            Arrays.fill(row,-1);
        }

        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2= 1; ind2 <= m; ind2++) {
                if (text1.charAt(ind1-1)==text2.charAt(ind2-1)){
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                }else{
                    dp[ind1][ind2] = Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); in.nextLine();

        while (t-->0){
            String text1 = in.next();
            String text2 = in.next();

            int res = longestCommonSubsequence(text1,text2);
            System.out.println(res);
        }
    }
}
