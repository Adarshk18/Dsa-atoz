import java.util.*;

public class SubarrayRanges {
    public static long subArrayRanges(int[] nums) {
        return sumMaximum(nums) - sumMinimum(nums);
    }

    public static long sumMaximum(int[] nums){
        int n= nums.length;
        long total =0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i==n || nums[st.peek()] < nums[i])){
                int mid = st.pop();
                int left = st.isEmpty() ? -1: st.peek();
                int right = i;

                long count =  (mid - left) * (right - mid);
                total += (long)nums[mid] * count;
            }
            st.push(i);
        }
        return total;
    }

    public static long sumMinimum(int[] nums){
        int n= nums.length;
        long total =0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i==n || nums[st.peek()] > nums[i])){
                int mid = st.pop();
                int left = st.isEmpty() ? -1: st.peek();
                int right = i;

                long count = (mid - left) * (right - mid);
                total += (long)nums[mid] * count;
            }
            st.push(i);
        }
        return total;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();

        while (t-->0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            System.out.println(subArrayRanges(arr));
        }
    }
}
