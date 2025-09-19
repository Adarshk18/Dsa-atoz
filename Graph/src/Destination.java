import java.util.*;

public class Destination {

    static class Pair{
        int first; int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int m = roads.length;
        for (int i = 0; i < m; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.first-b.first);
        int[] dist = new int[n];
        int[] ways = new int[n];
        Arrays.fill(dist, (int)(1e9));
        Arrays.fill(ways,0);
        dist[0] =0;
        ways[0] =1;
        pq.add(new Pair(0,0));
        int mod = (int)(1e9+7);
        while (!pq.isEmpty()){
            Pair p = pq.poll();
            int distt = p.first;
            int node = p.second;

            for(Pair it: adj.get(node)){
                int adjNode = it.first;
                int edw = it.second;

                if ( distt + edw < dist[adjNode]){
                    dist[adjNode] = distt + edw;
                    pq.add(new Pair(distt+edw,adjNode));
                    ways[adjNode] = ways[node];
                }else if (distt + edw == dist[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n-1]%mod;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();

        while (t-->0){
            int n = in.nextInt();
            int m = in.nextInt();

            int[][] roads = new int[m][3];

            for (int i = 0; i < m; i++) {
                roads[i][0] = in.nextInt();
                roads[i][1] = in.nextInt();
                roads[i][2] = in.nextInt();
            }


            int ans = countPaths(n,roads);
            System.out.println(ans);
        }
    }
}
