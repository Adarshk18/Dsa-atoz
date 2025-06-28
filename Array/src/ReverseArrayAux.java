import java.util.*;

public class ReverseArrayAux {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }


        int[] brr = new int[n];

        //loop for array reversal
        for (int i=n-1, j=0; i>=0; i--, j++) {
            brr[j] = arr[i];
        }

        //loop for copying the reverse array into original array
        for (int i = 0; i < n; i++) {
            arr[i] = brr[i];
        }

        //printing the reversed array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] +" ");
        }
        System.out.println();
    }
}
