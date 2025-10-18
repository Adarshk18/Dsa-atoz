import java.util.*;

public class HouseRobber {
    public static int solve(int[] nums){
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if (i>1) pick += prev2;

            int notPick = prev;

            int curr = Math.max(pick,notPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        if (n==1) return nums[0];

        for (int i = 0; i < n; i++) {
            if (i!=0) arr1.add(arr[i]);
            if (i!=n-1) arr2.add(arr[i])
        }

        int ans1 = solve(arr1);
        int ans2 = solve(arr2);

        return Math.max(ans1,ans2);
    }
    public static void main(String[] args) {

    }
}
