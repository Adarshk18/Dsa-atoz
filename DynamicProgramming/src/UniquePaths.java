import java.util.*;

public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (i==0 && j==0){
                    temp[j] = 1;
                    continue;
                }
                int up =0;
                int left =0;

                if (i>0) up = prev[j];
                if (j>0) left = temp[j-1];

                temp[j] = up+left;
            }
            prev = temp;
        }
        return prev[n-1];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-->0){
            int m = in.nextInt();
            int n = in.nextInt();
            System.out.println(uniquePaths(m,n));
        }
    }
}
