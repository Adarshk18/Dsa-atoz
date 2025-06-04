import java.util.*;

public class SubarraySum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t= in.nextInt();
        while (t-->0){
            int n = in.nextInt();
            int k = in.nextInt();
            int[] arr = new int[n];
            Map<Integer, Integer> mp = new HashMap<>();
            int prefSum =0,cnt=0;
            mp.put(0,1);
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();

                prefSum += arr[i];
                int remove = prefSum - k;
                cnt +=  mp.getOrDefault(remove,0);

                mp.put(prefSum,mp.getOrDefault(prefSum,0)+1);


            }
            System.out.println(cnt);
        }

    }
}
