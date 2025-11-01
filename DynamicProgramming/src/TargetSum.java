import java.util.*;

public class TargetSum {
    static int mod = (int)(Math.pow(10,9)+7);
    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int[] prev = new int[target+1];

        if (nums[0]==0){
            prev[0] = 2;
        }else{
            prev[0] = 1;
        }

        if (nums[0]!=0 && nums[0]<=target) prev[nums[0]] = 1;

        for (int ind = 1; ind < n; ind++) {
            int[] curr = new int[target+1];
            for (int tar = 0; tar <= target; tar++) {
                int notPick = prev[tar];
                int pick =0;
                if (nums[ind]<=tar) pick = prev[tar-nums[ind]];

                curr[tar] = (notPick + pick)%mod;
            }
            prev = curr;
        }
        return prev[target];
    }

    public static int targetSum(int n, int[] nums, int target){
        int tot = 0;
        for(int arr: nums){
            tot += arr;
        }

        if (tot -target <0 || (tot-target)%2==1){
            return 0;
        }

        return findTargetSumWays(nums,(tot-target)/2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }

            int target = in.nextInt();
            System.out.println(targetSum(n,nums,target));
        }
    }
}
