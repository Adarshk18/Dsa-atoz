import java.util.*;

public class SubArray {

    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long total = 0;
        int mod = 1000000007;

        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);

        for (int i = 0; i < n; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;

            total = (total +(long)left * right *arr[i])%mod;
        }
        return (int)total;
    }

    public static int[] findNSE(int[] arr){
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n-1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }
        return nse;
    }

    public static int[] findPSE(int[] arr){
        int n = arr.length;
        int[] pse = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }
        return pse;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();

        while (t-->0){
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            System.out.println(sumSubarrayMins(arr));
        }
    }
}
