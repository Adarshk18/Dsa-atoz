import java.util.*;

public class LIS1 {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] next = new int[n+1];
        int[] curr = new int[n+1];

        for (int ind = n-1; ind >= 0; ind--) {
            for (int prevInd = ind-1; prevInd >= -1; prevInd--) {
                int len = next[prevInd+1];
                if (prevInd==-1 || nums[ind] > nums[prevInd]){
                    len = Math.max(len,1 + next[ind+1]);
                }
                curr[prevInd+1]= len;
            }
            next = curr.clone();
        }
        return next[-1+1];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-->0){
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }

            int max = lengthOfLIS(nums);
            System.out.println(max);
        }
    }
}
