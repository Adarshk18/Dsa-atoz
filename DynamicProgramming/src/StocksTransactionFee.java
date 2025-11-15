import java.util.*;

public class StocksTransactionFee {

    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] ahead = new int[2];
        int[] curr = new int[2];


        for (int ind = n - 1; ind >= 0; ind--) {

            curr[1] = Math.max(-prices[ind] + ahead[0], ahead[1]);

            curr[0] = Math.max(prices[ind] - fee + ahead[1], ahead[0]);

            ahead = curr.clone();
        }
        return ahead[1];
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
            int fee = in.nextInt();
            int profit = maxProfit(arr, fee);
            System.out.println(profit);
        }
    }
}
