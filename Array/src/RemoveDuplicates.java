import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();

        }

        if (n==0){
            System.out.println(0);
            return;
        }

        int i=0;
        for (int j = 1; j < n; j++) {
            if (arr[i]!=arr[j]){
                i++;
                arr[i] = arr[j];
            }
        }
        System.out.println(i+1);

        for (int j = 0; j <= i; j++) {
            System.out.print(arr[j]+" ");
        }
    }
}
