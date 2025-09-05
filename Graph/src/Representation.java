import java.util.*;

public class Representation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }


            for (int i = 0; i < m; i++) {
                int u = in.nextInt();
                int v = in.nextInt();


                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            for (int i = 0; i < n; i++) {
                System.out.print(i + "->");
                for(int nodes: adj.get(i)){
                    System.out.print(nodes + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
