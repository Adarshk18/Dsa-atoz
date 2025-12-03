import java.util.*;

public class DivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();

        int[] dp = new int[n];
        Arrays.fill(dp,1);

        int[] hash = new int[n];

        int lastIndex = 0;
        int maxi = 1;

        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int prevInd = 0; prevInd < i; prevInd++) {
                if (nums[i]%nums[prevInd]==0 && dp[i] <dp[prevInd]+1){
                    dp[i] = dp[prevInd]+1;
                    hash[i] = prevInd;
                }
            }
            if (dp[i]>maxi){
                lastIndex = i;
                maxi = dp[i];
            }
        }
        int i = lastIndex;
        while (hash[i]!=i){
            ans.add(nums[i]);
            i = hash[i];
        }
        ans.add(nums[i]);

        Collections.reverse(ans);
        return ans;
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

            List<Integer> ans = largestDivisibleSubset(nums);
            System.out.print("[");
            for(int x : ans){
                System.out.print(x +" ");
            }
            System.out.println("]");
        }
    }
}
