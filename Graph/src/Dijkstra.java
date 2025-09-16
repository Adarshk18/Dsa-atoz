import java.util.*;

public class Dijkstra {
    static class Pair{
        int first;
        int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static List<Integer> shortestPath(int[][] edges, int N, int M, int src) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)-> x.first - y.first);
        int[] dist = new int[N+1];
        int[] parent = new int[N+1];

        Arrays.fill(dist,(int)1e9);
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        dist[src] =0;
        pq.add(new Pair(0,src));
        while (!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.second;
            int dis = curr.first;


            for(Pair is : adj.get(node)){
                int adjNode = is.second;
                int edw = is.first;
                if (dis + edw <dist[adjNode]){
                    dist[adjNode] = dis+edw;
                    pq.add(new Pair(dis+edw,adjNode));
                    parent[adjNode] = node;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if (dist[N] == (int)1e9) {
            path.add(-1);
            return path;
        }

        int node = N;
        while (parent[node]!=node){
            path.add(node);
            node = parent[node];
        }

        path.add(src);
        Collections.reverse(path);
        return path;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-->0){
            int N = in.nextInt();
            int M = in.nextInt();

            int[][] edges = new int[M][3];
            for (int i = 0; i < M; i++) {
                edges[i][0] = in.nextInt();
                edges[i][1] = in.nextInt();
                edges[i][2] = in.nextInt();
            }

            int src = in.nextInt();
            List<Integer> res = shortestPath(edges,N,M ,src);
            for (int it: res) {
                System.out.print(it + " ");
            }
            System.out.println();
        }
    }
}
