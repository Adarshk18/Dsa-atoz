import java.util.*;

public class SecondLargestElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i]>max){
                smax = max;
                max = arr[i];
            }else if(arr[i]>smax && arr[i]!=max){
                smax = arr[i];
            }
        }
        System.out.println(smax);
    }
}
