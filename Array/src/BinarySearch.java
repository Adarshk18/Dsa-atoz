import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        int key = in.nextInt();
        int left = 0, right = n - 1;
        boolean found = false;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                System.out.println(mid);
                found = true;
            } else if (arr[mid] < key) {
                left = mid + 1;

            } else {
                right = mid - 1;
            }
        }
        if (!found) {
            System.out.println(-1);
        }
    }
}
