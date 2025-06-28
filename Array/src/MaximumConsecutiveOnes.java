import java.util.*;

public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        while(t-->0){
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int cnt =0;
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i]==1){
                    cnt++;
                }else{
                    cnt=0;
                }
                max = Math.max(max,cnt);
            }
            System.out.println(max);
        }

    }
}
