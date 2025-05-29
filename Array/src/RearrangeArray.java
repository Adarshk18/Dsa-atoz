import java.util.*;

public class RearrangeArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();


        while (t-->0){
            int n = in.nextInt();
            int[] arr = new int[n];
            int[] ans = new int[n];

            int pos= 0, neg =1;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();

                if (arr[i]<0){
                    ans[neg] = arr[i];
                    neg +=2;
                }else{
                    ans[pos] = arr[i];
                    pos +=2;
                }
            }
            System.out.println(Arrays.toString(ans));
        }
    }
}
