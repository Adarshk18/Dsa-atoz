import java.util.*;

public class RotateImage {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }


            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n / 2; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - 1 - j];
                    matrix[i][n - 1 - j] = temp;
                }
            }


            System.out.print("[");
            for (int i = 0; i < n; i++) {
                System.out.print("[");
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j]);
                    if (j < n - 1) System.out.print(", ");
                }
                System.out.print("]");
                if (i < n - 1) System.out.print(", ");
            }
            System.out.println("]");
        }

        in.close();
    }
}
