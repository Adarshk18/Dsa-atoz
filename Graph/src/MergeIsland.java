import java.util.*;

class Disjoint5 {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public Disjoint5(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int root = findParent(parent.get(node));
        parent.set(node, root); // path compression
        return root;
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if (ulp_u == ulp_v) return;

        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

public class MergeIsland {

    public static boolean isValid(int newr, int newc, int n){
        return newr>=0 && newr<n && newc>=0 && newc<n;
    }

    public static int largestIsland(int[][] grid) {
        int n= grid.length;
        Disjoint5 ds = new Disjoint5(n*n);

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col]==0) continue;

                int[] dr = {-1,0,1,0};
                int[] dc = {0,1,0,-1};
                for (int ind = 0; ind < 4; ind++) {
                    int newr = row + dr[ind];
                    int newc = col +dc[ind];

                    if (isValid(newr,newc,n) && grid[newr][newc]==1){
                        int newNodeNo = row *n + col;
                        int adjNodeNo = newr * n + newc;
                        ds.unionBySize(newNodeNo,adjNodeNo);
                    }
                }
            }
        }

        int max = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col]==1) continue;

                int[] dr = {-1,0,1,0};
                int[] dc = {0,1,0,-1};
                HashSet<Integer> components = new HashSet<>();
                for (int ind = 0; ind < 4; ind++) {
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];

                    if (isValid(newr,newc,n)){
                        if (grid[newr][newc]==1){
                            components.add(ds.findParent(newr * n + newc));
                        }
                    }
                }
                int sizeTotal = 0;
                for(Integer parents: components){
                    sizeTotal += ds.size.get(parents);
                }
                max = Math.max(max,sizeTotal+1);
            }
        }
        for (int cellNo = 0; cellNo < n*n; cellNo++) {
            max = Math.max(max, ds.size.get(ds.findParent(cellNo)));
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();

        while (t-->0){
            int n = in.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = in.nextInt();
                }
            }

            int ans = largestIsland(grid);
            System.out.println(ans);
        }
    }
}
