import java.util.*;

//if there is a sequence of natural numbers

public class MissingElementSortedArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int sum =0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int x = (n+1)*(n+2)/2;
        System.out.println(x-sum);
    }
}
