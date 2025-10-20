import java.util.*;

public class HouseRobber {

    // Helper method to solve the linear version (House Robber I)
    public static int solve(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if (i > 1) pick += prev2;

            int notPick = prev;
            int curr = Math.max(pick, notPick);

            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    // Main function for circular houses
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // Exclude first house (take 1...n-1)
        int[] arr1 = Arrays.copyOfRange(nums, 1, n);
        // Exclude last house (take 0...n-2)
        int[] arr2 = Arrays.copyOfRange(nums, 0, n - 1);

        return Math.max(solve(arr1), solve(arr2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();

        for (int test = 1; test <= t; test++) {
            System.out.print("\nEnter number of houses: ");
            int n = sc.nextInt();

            int[] nums = new int[n];
            System.out.println("Enter money in each house:");
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            int result = rob(nums);
            System.out.println("Maximum money that can be robbed: " + result);
        }

        sc.close();
    }
}
