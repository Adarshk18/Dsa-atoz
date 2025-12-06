import java.util.*;

public class PalindromePartitioning {
    public static boolean isPalindrome(int i, int j, String s){
        while (i>j){
            if (s.charAt(i)!=s.charAt(j)){
               return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp,0);
        dp[n] = 0;

        for (int i = n-1; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (isPalindrome(i,n,s)){
                    int cost = 1 + dp[j+1];
                    minCost = Math.min(minCost,cost);
                }
            }
            dp[i] = minCost;
        }
        return dp[0];
    }
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());

        while (t-->0){
            String exp = in.nextLine().trim();
            int res = minCut(exp);
            System.out.println(res);

        }
    }
}
