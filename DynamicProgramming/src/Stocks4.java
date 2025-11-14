import java.util.*;


public class Stocks4 {
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[] after = new int[2*k+1];
        int[] curr = new int[2*k+1];

        for (int ind = n-1; ind >= 0; ind--) {
            for (int tranNo = 2*k-1; tranNo >= 0; tranNo--) {
                if (tranNo%2==0){
                    curr[tranNo] = Math.max(-prices[ind]+after[tranNo+1],after[tranNo]);
                }else{
                    curr[tranNo] = Math.max(prices[ind]+after[tranNo+1], after[tranNo]);
                }
            }
            after = curr.clone();
        }
        return after[0];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-->0){
            int n = in.nextInt();
            int[] prices = new int[n];
            for (int i = 0; i < n; i++) {
                prices[i] = in.nextInt();
            }

            int k = in.nextInt();
            int ans = maxProfit(k,prices);
            System.out.println(ans);
        }
    }
}
