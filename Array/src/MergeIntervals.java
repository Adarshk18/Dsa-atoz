import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = in.nextInt();
                arr[i][1] = in.nextInt();
            }


            Arrays.sort(arr, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
            });

            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)) {
                    ans.add(Arrays.asList(arr[i][0], arr[i][1]));
                } else {
                    ans.get(ans.size() - 1).set(1,
                            Math.max(ans.get(ans.size() - 1).get(1), arr[i][1]));
                }
            }

            System.out.print("[");
            for (List<Integer> it : ans) {
                System.out.print("[" + it.get(0) + ", " + it.get(1) + "]");
            }
            System.out.print("]");
            System.out.println();
        }
    }
}
