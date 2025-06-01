import java.util.*;

public class NextPermutation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t= in.nextInt();
        while (t-->0){
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            //find the break point
            int ind = -1;
            for (int i = n-2; i >= 0; i--) {
                if (arr[i]<arr[i+1]){
                    ind = i;
                    break;
                }
            }

            //if breakpoint does not exist
            if (ind==-1){
                for (int i=0, j=n-1; i<j; i++,j--) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                }
            }else{
                for (int i = n-1; i > ind; i--) {
                    if (arr[i]>arr[ind]){
                        int temp = arr[i];
                        arr[i] = arr[ind];
                        arr[ind] = temp;
                        break;
                    }
                }

                for (int i = ind+1,j=n-1; i < j; i++,j--) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.print("[");
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i]);
                if (i<n-1) System.out.print(", ");
            }
            System.out.println("]");
        }


    }
}
