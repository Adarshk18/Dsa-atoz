import java.util.*;

public class MissingElement2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            max = Math.max(max, arr[i]);
        }

        int[] H = new int[max + 1]; // to handle all values up to max
        Arrays.fill(H, 0);

        for (int i = 0; i < n; i++) {
            H[arr[i]]++;
        }

        for (int i = arr[0]; i <= max; i++) {
            if (H[i] == 0) {
                System.out.println(i);
            }
        }
    }
}
