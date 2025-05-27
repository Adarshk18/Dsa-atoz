import java.util.*;

public class InsertingInSortedArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        // i =n-1, shifting elements by right by checking if x is less than current element
        int x = in.nextInt();
        int i =n-1;
        while (i>=0 && arr[i]>x){
            arr[i+1]=arr[i];
            i--;
        }
        arr[i+1] = x;

        for (int j = 0; j <= n; j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();
    }
}
