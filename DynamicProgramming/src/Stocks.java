import java.util.*;

public class Stocks {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int mini = prices[0];
        int profit = 0;
        for (int i = 1; i < n; i++) {
            int cost = prices[i]- mini;
            profit = Math.max(profit,cost);
            mini = Math.min(mini,prices[i]);
        }
        return profit;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while(t-->0){
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
