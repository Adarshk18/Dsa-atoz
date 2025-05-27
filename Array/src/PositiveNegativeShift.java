import java.util.*;

public class PositiveNegativeShift {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int i=0, j=n-1;
        while(i<j){
            while (i<n && arr[i]<0 || j>=0 && arr[j]>=0){
                i++;
                j--;
            }

            if (i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int partitionIndex =0;
        while(partitionIndex < n && arr[partitionIndex]<0){
            partitionIndex++;
        }

        Arrays.sort(arr,0,partitionIndex); //left half sorting
        Arrays.sort(arr,partitionIndex,n); // right half sorting

        for (int k = 0; k < n; k++) {
            System.out.print(arr[k] + " ");
        }
        System.out.println();
    }
}
