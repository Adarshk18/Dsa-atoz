import java.util.*;

public class CutStick {

    public static int find(int i, int j, List<Integer> cut){
        if (i>j) return 0;

        int mini = Integer.MAX_VALUE;
        for (int ind = i; ind <= j; ind++) {
            int cost = cut.get(j+1)-cut.get(i-1) + find(i,ind-1,cut) + find(ind+1,j,cut);
            mini = Math.min(mini,cost);
        }
        return mini;
    }

    public static int minCost(int n, int[] cuts) {
        List<Integer> cut = new ArrayList<>();
        for(int c: cuts) cut.add(c);

        cut.add(n);
        cut.add(0);
        Collections.sort(cut);

        return find(1,cut.size()-2,cut);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            int c = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int len = minCost(c,arr);
            System.out.println(len);
        }
    }
}
