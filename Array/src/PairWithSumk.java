import java.util.*;

public class PairWithSumk {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

//        int max = Integer.MIN_VALUE;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
//            max = Math.max(max,arr[i]);
        }

//        int[] H = new int[max+1];
//        Arrays.fill(H,0);

//        for (int i = 0; i < n; i++) {
//            H[arr[i]]++;
//        }
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int x = k-arr[i];
            if (s.contains(x)){
                System.out.println("Pair found: (" + arr[i] + ", " + x + ")");
            }
            s.add(arr[i]);
        }


    }
}
