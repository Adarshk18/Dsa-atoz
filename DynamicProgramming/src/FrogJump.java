import java.util.*;

public class FrogJump {
    public static int frogJump(int[] heights) {
        int n = heights.length;

        int prev = 0;
        int prev2 = 0;
        for (int i = 1; i < n; i++) {
            int left = prev + Math.abs(heights[i] - heights[i-1]);
            int right = Integer.MAX_VALUE;
            if (i>1) right = prev2 + Math.abs(heights[i] - heights[i-2]);

            int curr = Math.min(left,right);
            prev2 = prev;
            prev = curr;

        }
        return prev;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();

        while (t-->0){
            int n = in.nextInt();
            int[] heights = new int[n];
            for (int i = 0; i < n; i++) {
                heights[i] = in.nextInt();
            }
            System.out.println(frogJump(heights));
        }
    }
}
