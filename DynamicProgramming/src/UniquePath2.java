import java.util.*;

public class UniquePath2 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] prev = new int[m];

        for (int i = 0; i < n; i++) {
            int[] temp = new int[m];
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == -1) {
                    temp[j] = 0;
                    continue;
                }

                if (i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }

                int up = 0, left = 0;

                if (i > 0) up = prev[j];
                if (j > 0) left = temp[j - 1];

                temp[j] = up + left;
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
            System.out.println(uniquePathsWithObstacles(obs));
        }
    }
}
