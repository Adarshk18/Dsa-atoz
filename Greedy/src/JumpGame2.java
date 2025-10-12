import java.util.*;

public class JumpGame2 {
    public static int canJump(int[] nums) {
        int n = nums.length;
        int maxIndex = 0;
        int jump =0;
        int current = 0;

        for (int i = 0; i < n-1; i++) {
            maxIndex = Math.max(maxIndex,i + nums[i]);

            if (i==current){
                jump++;
                current = maxIndex;
            }
        }
        return jump;
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
            int res = canJump(nums);
            System.out.println(res);
        }
    }
}
