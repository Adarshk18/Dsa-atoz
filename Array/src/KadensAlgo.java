import java.util.*;

public class KadensAlgo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t= in.nextInt();
        while (t-->0){
            int n = in.nextInt();
            int[] arr = new int[n];

            long maxi = Integer.MIN_VALUE;
            long sum =0;

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();

                sum +=arr[i];
                if (sum>maxi){
                    maxi = sum;
                }

                if (sum<0){
                    sum =0;
                }
            }
            System.out.println(maxi);
        }
    }
}
