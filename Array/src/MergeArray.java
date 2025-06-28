import java.util.*;

public class MergeArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t= in.nextInt();
        while (t-->0){
            int m = in.nextInt();
            int n = in.nextInt();
            int[] arr1 = new int[m+n];
            int[] arr2 = new int[n];

            for (int i = 0; i < m; i++) {
                arr1[i] = in.nextInt();
            }

            for (int i = 0; i < n; i++) {
                arr2[i] = in.nextInt();
            }

            int i= m-1;
            int j = n-1;
            int k = m+n-1;

            while(i>=0 && j>=0){
                if (arr1[i]>arr2[j]){
                   arr1[k--] = arr1[i--];
                }else{
                    arr1[k--] = arr2[j--];
                }
            }
            while (j>=0){
                arr1[k--] = arr2[j--];
            }

            System.out.print("[");
            for (int x = 0; x < m+n; x++) {
                System.out.print(arr1[x]);
                if (x>=0){
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }
        in.close();
    }
}
