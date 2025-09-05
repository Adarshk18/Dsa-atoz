import java.util.*;

public class BFS {

    public static ArrayList<Integer> bfsGraph(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            for(Integer it: adj.get(node)){
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();

        while (t-->0) {
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

            ArrayList<Integer> res = bfsGraph(n, adj);
            for(int x: res){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
