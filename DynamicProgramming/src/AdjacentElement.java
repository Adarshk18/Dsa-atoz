import java.util.*;

public class AdjacentElement {
//    public static int function(int ind, int[] nums, int[] dp){
//        if (ind==0) return nums[ind];
//        if (ind<0) return 0;
//        if (dp[ind]!=-1) return dp[ind];
//
//        int pick = nums[ind] + function(ind-2,nums,dp);
//        int notPick = function(ind-1,nums,dp);
//
//        return dp[ind] = Math.max(pick,notPick);
//    }
    public static int rob(int[] nums) {
        int n  = nums.length;
//        int[] dp = new int[n+1];
//        Arrays.fill(dp,-1);
        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if(i>1) pick += prev2;
            int notPick = prev;

            int curr = Math.max(pick,notPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
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
            int max = rob(nums);
            System.out.println(max);
        }
    }
}
