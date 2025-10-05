import java.util.*;

public class ArticulationPoint {

    private static int timer = 1;
    private static void dfs(int node, int parent, int[] vis,int[] tin, int[] low, int[] mark, ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;
        int child =0;
        for(Integer it: adj.get(node)){
            if (it==parent) continue;

            if (vis[node]==0){
                dfs(it,node,vis,tin,low,mark,adj);
                low[node] = Math.max(low[node],low[it]);

                if (low[it]>=tin[node] && parent!=-1){
                    mark[node] = 1;
                }
                child++;
            }else{
                low[node] = Math.min(low[node],tin[it]);
            }
        }
        if (child >1 && parent==-1){
            mark[node] = 1;
        }
    }
    public static ArrayList<Integer> articulationPoints(int n, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        int[] mark = new int[n];

        timer = 1;

        for (int i = 0; i < n; i++) {
            if (vis[i]==0){
                dfs(i,-1,vis,tin,low,mark,adj);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mark[i]==1){
                ans.add(i);
            }
        }
        if (ans.isEmpty()){
            ans.add(-1);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();
        while (t-->0){
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

            ArrayList<Integer> nodes = articulationPoints(n,adj);
            for(int x: nodes){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
