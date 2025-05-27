import java.util.*;

public class AddElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        
        List<Integer> ls = new ArrayList<>();
        for(int num: arr){
            ls.add(num);
        }

        int x = in.nextInt();
        ls.add(x);

        System.out.println(ls);
    }
}
