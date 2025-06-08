import java.util.*;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t =in.nextInt();
        while (t-->0){
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            if (arr == null || n==0){
                return;
            }
            int maxProd = arr[0];
            int minProd = arr[0];
            int result = arr[0];
            for (int i = 1; i < n; i++) {
                if (arr[i]<0){
                    int temp = maxProd;
                    maxProd = minProd;
                    minProd = temp;
                }

                maxProd = Math.max(arr[i],maxProd*arr[i]);
                minProd = Math.min(arr[i],minProd*arr[i]);

                result = Math.max(result,maxProd);
            }
            System.out.println(result);
        }
    }
}
