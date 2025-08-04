import java.util.*;

public class NGE2 {

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 2*n-1; i >= 0; i--) {
            int curr = nums[i%n];

            while (!st.isEmpty() && st.peek() <= curr){
                st.pop();
            }
            if (i<n){
                res[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(curr);
        }
        return res;
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

            System.out.println(Arrays.toString(nextGreaterElements(nums)));
        }
    }
}
