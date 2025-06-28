import java.util.*;

//Move zeros to end

public class MoveZeros {

    public static int[] zeros(int[] arr, int n){
        int j=-1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0){
                j=i;
                break;
            }
        }

        if (j==-1) return arr;

        for (int i = j+1; i < n; i++) {
            if (arr[i]!=0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int ind = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i]!=0){
                arr[ind++] = arr[i];
            }
        }

        while (ind<n){
            arr[ind++] = 0;
        }

//        zeros(arr,n);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
