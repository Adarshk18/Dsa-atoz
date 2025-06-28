import java.util.*;

public class CheckSorted {

    public static boolean isSorted(int[] arr, int n){
        for (int i = 0; i < n-1; i++) {
            if (arr[i]>arr[i+1]){
                return  false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(isSorted(arr,n));
    }
}
