import java.util.*;

public class FractionalKnapsack {
    static class Item{
        int value,weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }

    static class itemComparator implements Comparator<Item>{
        @Override
        public int compare(Item a, Item b){
            double r1 = (double)(a.value)/(double) (a.weight);
            double r2 = (double) (b.value)/(double) (b.weight);
            if (r1<r2) return 1;
            else if (r1>r2) return -1;
            else return 0;
        }
    }
    public static double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr,new itemComparator());

        int currWeight = 0;
        double finalValue = 0.0;
        for (int i = 0; i < n; i++) {
            if (currWeight + arr[i].weight <= W){
                currWeight += arr[i].weight;
                finalValue += arr[i].value;
            }else{
                int rem = W-currWeight;
                finalValue += ((double)arr[i].value / (double)arr[i].weight) * (double) rem;
                break;
            }
        }
        return finalValue;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-->0){
            int n = in.nextInt();
            int W = in.nextInt();

            int[] values = new int[n];
            int[] weight = new int[n];
            for (int i = 0; i < n; i++) {
                values[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                weight[i] = in.nextInt();
            }

            Item[] items = new Item[n];
            for (int i = 0; i < n; i++) {
                items[i] = new Item(values[i], weight[i]);
            }

            double ans = fractionalKnapsack(W,items,n);
            System.out.printf("%.2f\n",ans);
        }
    }
}
