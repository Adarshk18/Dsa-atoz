import java.util.*;

public class MajorityCount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();
        while (t-->0){
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int cnt =0;
            int el =0;
            for (int i = 0; i < n; i++) {
                if (cnt==0){
                    cnt=1;
                    el = arr[i];
                }else if (el==arr[i]) cnt++;
                else cnt--;
            }

            int cnt1=0;
            for (int i = 0; i < n; i++) {
                if (arr[i]==el) cnt1++;
            }
            if (cnt1>(n/2)){
                System.out.println(el);
            }
        }
    }
}
