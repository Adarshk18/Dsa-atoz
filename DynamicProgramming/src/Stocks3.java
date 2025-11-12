import java.util.*;

public class Stocks3 {


    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (buy == 1) {
                         dp[ind][buy][cap] = Math.max(-prices[ind] + dp[ind+1][0][cap], dp[ind+1][1][cap]);
                    } else {
                         dp[ind][buy][cap] = Math.max(prices[ind] + dp[ind+1][1][cap-1], dp[ind+1][0][cap]);
                    }

                }
            }
        }
        return dp[0][1][2];
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
