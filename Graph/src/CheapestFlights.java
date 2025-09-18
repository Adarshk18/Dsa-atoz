import java.util.*;

public class CheapestFlights {
    static class Pair{
        int first;
        int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    static class Tuple{
        int first;
        int second; int third;

        Tuple(int first, int second, int third){
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int m = flights.length;
        for (int i = 0; i < m; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,src,0));

        int[] dist = new int[n];
        Arrays.fill(dist, (int)(1e9));
        dist[src] =0;

        while (!q.isEmpty()){
            Tuple it = q.poll();
            int stops = it.first;
            int node = it.second;
            int cost = it.third;

            if (stops>k) continue;
            for(Pair iter: adj.get(node)){
                int adjNode = iter.first;
                int edw = iter.second;

                if (cost+edw < dist[adjNode]){
                    dist[adjNode] = cost+edw;
                    q.add(new Tuple(stops+1,adjNode,cost+edw));
                }
            }
        }

        if (dist[dst]==(int)(1e9)) return -1;
        return dist[dst];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();

        while (t-->0){
            int n = in.nextInt();
            int m = in.nextInt();

            int[][] flights = new int[m][3];
            for (int i = 0; i < m; i++) {
               flights[i][0] = in.nextInt();
               flights[i][1] = in.nextInt();
               flights[i][2] = in.nextInt();
            }

            int src = in.nextInt();
            int dst = in.nextInt();
            int k = in.nextInt();

            int ans = findCheapestPrice(n,flights,src,dst,k);
            System.out.println(ans);
        }
    }
}
