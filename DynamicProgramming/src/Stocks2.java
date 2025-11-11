import java.util.*;

public class Stocks2 {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[n][0] = dp[n][1] = 0;
        for(int[] row: dp){
            Arrays.fill(row,0);
        }

        for (int ind = n-1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit =0;
                if (buy==1){
                    profit = Math.max(-prices[ind] + dp[ind+1][0], dp[ind+1][1]);
                }else{
                    profit = Math.max(prices[ind] + dp[ind+1][1],  dp[ind+1][0]);
                }
                dp[ind][buy] = profit;
            }
        }
        return dp[0][1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int profit = maxProfit(arr);
            System.out.println(profit);
        }
    }
}
