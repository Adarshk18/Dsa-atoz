import java.util.*;

public class MoreMissingElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int diff = arr[0]-0;
        for (int i = 0; i < n; i++) {
            if (arr[i]-i!=diff){
                while (diff<arr[i]-i){
                    System.out.print(i+diff + " ");
                    diff++;
                }

            }
        }
    }
}
