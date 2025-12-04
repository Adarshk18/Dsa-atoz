import java.util.*;

public class NoOfLIS {
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] cnt = new int[n];
        Arrays.fill(cnt, 1);

        int maxi = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    cnt[i] = cnt[j];
                }else if (nums[i]>nums[j] && dp[j]+1 == dp[i]){
                    cnt[i] += cnt[j];
                }
            }
            maxi = Math.max(maxi,dp[i]);
        }
        int no =0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxi) no += cnt[i];
        }
        return no;
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
            System.out.println(findNumberOfLIS(nums));
        }
    }
}
