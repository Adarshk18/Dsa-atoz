import java.util.*;

public class Leaders {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int[] ans = new int[n];
            int cnt =0;

            int max = arr[n-1];
            ans[cnt++] = max;

            for (int i = n-2; i >= 0; i--) {
                if (arr[i]>max){
                    max = arr[i];
                    ans[cnt++] = max;
                }
            }
            for (int i = cnt-1; i >= 0; i--) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
