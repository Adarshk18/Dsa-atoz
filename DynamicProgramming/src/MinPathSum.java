import java.util.*;

public class MinPathSum {
    public static int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] prev = new int[m];
        for (int i = 0; i < n; i++) {
            int[] temp = new int[m];
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                   temp[j] = grid[i][j];
                } else {
                    int up = grid[i][j];
                    if (i > 0) up += prev[j];
                    else up += (int)1e9;

                    int left = grid[i][j];
                    if (j> 0) left += temp[j - 1];
                    else left += (int)1e9;


                    temp[j] = Math.min(up, left);
                }
            }
            prev = temp;
        }
        return prev[m - 1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] obs = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    obs[i][j] = in.nextInt();
                }
            }
            System.out.println(minPathSum(obs));
        }
    }
}
