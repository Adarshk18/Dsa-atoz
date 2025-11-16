import java.util.*;

public class LIS1 {

    public static int func(int ind, int prevInd, int[] nums){
        int n = nums.length;
        if (ind==n) return 0;

        int len = func(ind+1,prevInd,nums);
        if (prevInd==-1 || nums[ind] > nums[prevInd]){
            len = Math.max(len,1 + func(ind+1,ind,nums));
        }
        return len;
    }
    public static int lengthOfLIS(int[] nums) {
        return func(0,-1,nums);
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
