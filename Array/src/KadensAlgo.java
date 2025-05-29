import java.util.*;

public class KadensAlgo {

    public static int max(int[] arr, int n){
        long maxi = Integer.MIN_VALUE;
        long sum =0;

        for (int i = 0; i < n; i++) {
            sum +=arr[i];
            if (sum>maxi){
                maxi = sum;
            }

            if (sum<0){
                sum =0;
            }
        }
        return (int) maxi;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t= in.nextInt();
        while (t-->0){
            int n = in.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int x = max(arr,n);
            System.out.println(x);
        }


    }
}
