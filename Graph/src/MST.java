import java.util.*;

public class MST {
    static class Pair{
        int distance; int node;

        Pair(int distance, int node){
            this.distance = distance;
            this.node = node;
        }
    }
    public static int spanningTree(int V, List<List<List<Integer>>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.distance-b.distance);
        int[] vis = new int[V];
        pq.add(new Pair(0,0));
        int sum =0;
        while (!pq.isEmpty()){
            Pair it = pq.poll();
            int wt = it.distance;
            int node = it.node;

            if (vis[node]==1) continue;
            vis[node] = 1;
            sum += wt;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edw = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if (vis[adjNode]==0){
                    pq.add(new Pair(edw,adjNode));
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();

        while (t-->0){
            int V = in.nextInt();
            int E = in.nextInt();

            List<List<List<Integer>>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                int w = in.nextInt();

                adj.get(u).add(Arrays.asList(v,w));
                adj.get(v).add(Arrays.asList(u,w));
            }

            int sum = spanningTree(V,adj);
            System.out.println(sum);
        }
    }
}
