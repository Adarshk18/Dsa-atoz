import java.util.*;

public class CutStick {

    public static int minCost(int n, int[] cuts) {

        List<Integer> cut = new ArrayList<>();

        for (int c : cuts) cut.add(c);

        cut.add(0);
        cut.add(n);
        Collections.sort(cut);

        int c = cut.size() - 2;

        int[][] dp = new int[c + 2][c + 2];


        for (int len = 1; len <= c; len++) {
            for (int i = 1; i + len - 1 <= c; i++) {

                int j = i + len - 1;

                int mini = Integer.MAX_VALUE;

                for (int ind = i; ind <= j; ind++) {

                    int cost = (cut.get(j + 1) - cut.get(i - 1))
                            + dp[i][ind - 1]
                            + dp[ind + 1][j];

                    mini = Math.min(mini, cost);
                }

                dp[i][j] = mini;
            }
        }

        return dp[1][c];
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-- > 0) {

            int n = in.nextInt();
            int c = in.nextInt();

            int[] arr = new int[c];
            for (int i = 0; i < c; i++) arr[i] = in.nextInt();

            int ans = minCost(n, arr);
            System.out.println(ans);
        }
    }
}
