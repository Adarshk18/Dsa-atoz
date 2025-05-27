import java.util.Arrays;
import java.util.Scanner;

public class DuplicatesUnsortedArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            max = Math.max(max,arr[i]);
        }

        int[] H = new int[max+1];
        Arrays.fill(H,0);

        for (int i = 0; i < n; i++) {
            H[arr[i]]++;
        }

        for (int i = 0; i <= max; i++) {
            if (H[i]>1){
                System.out.println(i + " appears " + H[i] + " times ");
            }
        }

    }
}
