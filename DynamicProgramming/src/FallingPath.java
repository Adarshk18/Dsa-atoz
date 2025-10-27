import java.util.*;

public class FallingPath {
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] prev = Arrays.copyOf(matrix[n-1],m);

        for(int row=n-2; row>=0; row--){
            int[] curr = new int[m];
            for(int col=0; col<m; col++){
                int down = prev[col];
                int dleft = (col > 0) ? prev[col-1] : Integer.MAX_VALUE;
                int dright = (col < m-1) ? prev[col+1] : Integer.MAX_VALUE;

                curr[col] = matrix[row][col] + Math.min(down, Math.min(dleft,dright));

            }
            prev = curr;
        }
        int minSum = Integer.MAX_VALUE;
        for(int val: prev){
            minSum = Math.min(minSum, val);
        }
        return minSum;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-->0){
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            int ans = minFallingPathSum(matrix);
            System.out.println(ans);
        }
    }
}
