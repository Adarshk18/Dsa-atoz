import java.util.*;

public class StockBuy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();


        while (t-->0){
            int n = in.nextInt();
            int[] arr = new int[n];
            int maxProfit = 0;
            int minPrice = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();

                minPrice  = Math.min(minPrice,arr[i]);
                maxProfit = Math.max(maxProfit,arr[i]-minPrice);
            }
            System.out.println(maxProfit);


        }
    }
}
