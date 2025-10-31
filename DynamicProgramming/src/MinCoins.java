import java.util.*;

public class MinCoins {
    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[] prev = new int[amount+1];
        int[] curr = new int[amount+1];


        for (int T = 0; T <= amount; T++) {
            if (T%coins[0]==0){
                prev[T] = T/coins[0];
            }else{
               prev[T] = (int)(1e9);
            }
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= amount; target++) {
                int notTake = prev[target];
                int take = Integer.MAX_VALUE;
                if (coins[ind]<=target) take = 1 + curr[target-coins[ind]];

                curr[target] = Math.min(notTake,take);
            }
            prev = curr;
        }

        int ans = prev[amount];
        return  (ans>=(int)(1e9)) ? -1: ans;

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-->0){
            int n = in.nextInt();
            int[] coins = new int[n];
            for (int i = 0; i < n; i++) {
                coins[i] = in.nextInt();
            }

            int amount = in.nextInt();
            int ans = coinChange(coins,amount);
            System.out.println(ans);
        }
    }
}
