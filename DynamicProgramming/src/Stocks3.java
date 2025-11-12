import java.util.*;

public class Stocks3 {


    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] after = new int[2][3];
        int[][] curr = new int[2][3];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (buy == 1) {
                         curr[buy][cap] = Math.max(-prices[ind] +after[0][cap], after[1][cap]);
                    } else {
                        curr[buy][cap] = Math.max(prices[ind] + after[1][cap-1], after[0][cap]);
                    }

                }
            }
            after = curr;
        }
        return after[1][2];
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
