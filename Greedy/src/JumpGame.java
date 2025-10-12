import java.util.*;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {
            if (i > maxIndex) return false;

            maxIndex = Math.max(maxIndex,i + nums[i]);
        }
        return true;
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
            boolean res = canJump(nums);
            System.out.println(res ? "true": "false");
        }
    }
}
