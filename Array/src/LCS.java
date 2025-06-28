import java.util.*;

public class LCS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            if (n==0) System.out.println(0);
            int longest = 1;

            Set<Integer> st = new HashSet<>();
            for (int i = 0; i < n; i++) {
                st.add(arr[i]);
            }
            for(int it: st){
                if (!st.contains(it-1)){
                    int cnt =1;
                    int x = it;

                    while (st.contains(x+1)){
                         x +=1;
                         cnt +=1;
                    }
                    longest = Math.max(longest,cnt);
                }
            }
            System.out.println(longest);
        }
    }
}
