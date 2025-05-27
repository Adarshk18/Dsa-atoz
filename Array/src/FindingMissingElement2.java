import java.util.*;

public class FindingMissingElement2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int l = arr[0];
        int h = arr[n-1];

        int diff = l-0;
        for (int i = 0; i < n; i++) {
            if (arr[i]-i!=diff){
                System.out.println(i+diff);
                break;
            }
        }
    }
}
