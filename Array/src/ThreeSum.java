import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            Arrays.sort(arr);
            List<List<Integer>> ans = new ArrayList<>();

            for (int i = 0; i < n - 2; i++) {
                if (i > 0 && arr[i] == arr[i - 1]) continue;

                int j = i + 1;
                int k = n - 1;

                while (j < k) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum < 0) {
                        j++;
                    } else if (sum > 0) {
                        k--;
                    } else {
                        ans.add(Arrays.asList(arr[i], arr[j], arr[k]));
                        j++;
                        k--;
                        while (j < k && arr[j] == arr[j - 1]) j++;
                        while (j < k && arr[k] == arr[k + 1]) k--;
                    }
                }
            }


            for (List<Integer> triplet : ans) {
                System.out.print("[");
                for (int num : triplet) {
                    System.out.print(num + ", ");
                }
                System.out.print("]");
            }
            System.out.println();
        }

        in.close();
    }
}
