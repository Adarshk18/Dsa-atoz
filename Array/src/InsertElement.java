import java.util.*;

public class InsertElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int x = in.nextInt();
        int pos = in.nextInt();

        int[] newArray = new int[n+1];
        for (int i = 0; i < pos; i++) {
            newArray[i] = arr[i];
        }

        newArray[pos] = x;
        //shifting
        for (int i = pos; i < n; i++) {
            newArray[i+1] = arr[i];
        }

        System.out.println(Arrays.toString(newArray));
    }
}
