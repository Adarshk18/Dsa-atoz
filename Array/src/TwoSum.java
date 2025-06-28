import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int target = in.nextInt();
            int[] arr = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            boolean found = false;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();

                if (map.containsKey(target - arr[i])) {
                    System.out.println("YES");
                    System.out.println(map.get(target - arr[i]) + " " + i);
                    found = true;
                    break;
                }
                map.put(arr[i], i);
            }
            if (!found) {
                System.out.println("NO");
            }

        }
    }
}