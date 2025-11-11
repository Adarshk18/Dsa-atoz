import java.util.*;

public class Stocks2 {

    public static int function(int[] prices, int ind, int buy, int[][] dp){
        int n = prices.length;

        if (ind==n) return 0;
        if (dp[ind][buy]!=-1) return dp[ind][buy];

        int profit =0;
        if (buy==1){
            profit = Math.max(-prices[ind] + function(prices,ind+1,0,dp), function(prices,ind+1,1,dp));
        }else{
            profit = Math.max(prices[ind] + function(prices,ind+1,1,dp),  function(prices,ind+1,0,dp));
        }
        return dp[ind][buy] = profit;
    }
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return function(prices,0,1,dp);
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
