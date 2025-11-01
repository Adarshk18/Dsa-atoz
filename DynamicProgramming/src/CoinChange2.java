import java.util.*;

public class CoinChange2 {
    public static int change(int amount, int[] coins) {
        int n = coins.length;

        int[] prev = new int[amount+1];

        for (int i = 0; i <= amount; i++) {
            if (i%coins[0]==0) prev[i] = 1;
        }

        for (int ind = 1; ind < n; ind++) {
            int[] curr = new int[amount+1];
            for (int target = 0; target <= amount; target++) {
                int notPick = prev[target];
                int pick = 0;
                if (coins[ind]<=target) pick = curr[target-coins[ind]];

                curr[target] = notPick + pick;
            }
            prev = curr;
        }
        return prev[amount];
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
            System.out.println(change(amount,coins));
        }
    }
}
