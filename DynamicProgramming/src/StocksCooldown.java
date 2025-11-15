import java.util.*;

public class StocksCooldown {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[] f1 = new int[2];
        int[] f2 = new int[2];
        int[] curr = new int[2];
        for (int ind = n-1; ind >= 0; ind--) {
            curr[1] = Math.max(-prices[ind]+f1[0],f1[1]);

            curr[0] = Math.max(prices[ind]+f2[1],f1[0]);

            f2 = f1.clone();
            f1 = curr.clone();
        }
        return curr[1];
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
