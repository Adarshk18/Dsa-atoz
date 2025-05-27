import java.util.*;

public class LeftRotateArray {

    public static void Reverse(int[] arr, int start, int end){
        while (start<=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static void rotateArray(int[] arr, int n, int k){
        k = k%n;

        Reverse(arr,0,n-1);
        Reverse(arr,0,k-1);
        Reverse(arr,k,n-1);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        while(t-->0){
            int n = in.nextInt();
            int k = in.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }



            rotateArray(arr,n,k);

            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        }
        in.close();

    }
}
