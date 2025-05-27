import java.util.*;

public class LargestSubarray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while(t-->0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int right =0,left=0;
            long sum = arr[0];
            int maxLen = 0;

            while (right<n){
                while (left<=right && sum>k){
                    sum -= arr[left];
                    left++;
                }

                if (sum==k){
                    maxLen = Math.max(maxLen,right-left+1);
                }
                right++;
                if (right<n){
                    sum += arr[right];
                }
            }
            System.out.println(maxLen);
        }
    }
}
