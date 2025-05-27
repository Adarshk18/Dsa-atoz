import java.util.*;

public class searchElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int x = in.nextInt();
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (arr[i] == x){
                System.out.println(i);
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println(-1);
        }
    }
}
