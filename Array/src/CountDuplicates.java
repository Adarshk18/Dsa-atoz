import java.util.Scanner;

public class CountDuplicates {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        for (int i = 0; i < n-1; i++) {
            if (arr[i]==arr[i+1]){
                int j = i+1;
                while (j<n && arr[j]==arr[i]){
                    j++;
                }
                System.out.println(arr[i] + " appears " + (j-i) + " times ");
                i=j-1;
            }
        }
    }
}
