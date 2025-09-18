import java.util.*;

public class DelayTime {
    public static  int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] time: times){
            int u = time[0];
            int v = time[1];
            int w = time[2];

            adj.get(u).add(new int[]{v,w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0,k});

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            int time = curr[0];
            int  node = curr[1];

            if (time > dist[node]) continue;

            for(int[] nb: adj.get(node)){
                int v = nb[0];
                int wt = nb[1];

                if (time + wt < dist[v]){
                    dist[v] = time+wt;
                    pq.add(new int[]{dist[v],v});
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i]==Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();

        while (t-->0){
            int n = in.nextInt();
            int m = in.nextInt();

            int[][] times = new int[m][3];
            for (int i = 0; i < m; i++) {
                times[i][0] = in.nextInt();
                times[i][1] = in.nextInt();
                times[i][2] = in.nextInt();
            }

            int k = in.nextInt();
            int ans = networkDelayTime(times,n,k);
            System.out.println(ans);
        }
    }
}
