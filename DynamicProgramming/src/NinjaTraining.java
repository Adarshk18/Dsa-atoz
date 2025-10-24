import java.util.*;

public class NinjaTraining {
    public static int ninjaTraining(int[][] matrix) {
        int n = matrix.length;

        int[] dp = new int[4];
        dp[0] = Math.max(matrix[0][1], matrix[0][2]);
        dp[1] = Math.max(matrix[0][0], matrix[0][2]);
        dp[2] = Math.max(matrix[0][0], matrix[0][1]);
        dp[3] = Math.max(matrix[0][0], Math.max(matrix[0][1], matrix[0][2]));

        for (int day = 1; day < n; day++) {
            int[] temp = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task!=last){
                        temp[last] = Math.max(temp[last],matrix[day][task]+ dp[task]);
                    }
                }
            }
            dp = temp;
        }
        return dp[3];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-->0){
            int n = in.nextInt();
            int[][] matrix = new int[n][3];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            System.out.println(ninjaTraining(matrix));
        }
    }
}
