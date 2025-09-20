import java.util.*;

public class BellmanFord {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist,(int)(1e9));
        dist[S] = 0;

        for (int i = 0; i < V-1; i++) {
            for(ArrayList<Integer> it: edges){
                int u = it.get(0);
                int v = it.get(1);
                int w = it.get(2);

                if (dist[u]!=1e9 && dist[u] +w <dist[v]){
                    dist[v] = dist[u] + w;
                }
            }
        }

        for(ArrayList<Integer> it: edges){
            int u = it.get(0);
            int v = it.get(1);
            int w = it.get(2);

            if (dist[u]!=1e9 && dist[u] +w <dist[v]){
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-->0){
            int V = in.nextInt();

            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                edges.add(new ArrayList<>());
            }

            int S = in.nextInt();
            int[] dist = bellman_ford(V,edges,S);
            for (int i = 0; i < V; i++) {
                System.out.print(dist[i] + " ");
            }
            System.out.println();
        }
    }
}
