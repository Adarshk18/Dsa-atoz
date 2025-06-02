import java .util.*;

public class SetMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();
        while (t-->0){
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            int col0 = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {


                    if (matrix[i][j] == 0){
                        matrix[i][0] = 0;
                        if (j!=0){
                            matrix[0][j] = 0;
                        }else{
                            col0 = 0;
                        }
                    }

                }
            }

            //2.
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (matrix[i][0]==0 || matrix[0][j]==0){
                        matrix[i][j] = 0;
                    }
                }
            }

            //3
            if (matrix[0][0] ==0){
                for (int j = 0; j < m; j++) {
                    matrix[0][j] = 0;
                }
            }

            //4
            if (col0==0){
                for (int i = 0; i < n; i++) {
                    matrix[i][0] = 0;
                }
            }
            System.out.print("[");
            for (int i = 0; i < n; i++) {
                System.out.print("[");
                for (int j = 0; j < m; j++) {
                    System.out.print(matrix[i][j]);
                    if (j < m - 1) System.out.print(", ");
                }
                System.out.print("]");
                if (i < n - 1) System.out.print(", ");

            }
            System.out.println("]");
        }
    }
}
