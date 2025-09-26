import java.util.*;

class Disjoint4 {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public Disjoint4(int n) {
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

public class Island2 {

    public static boolean isValid(int adjr, int adjc, int n, int m){
        return adjr>=0 && adjr<n && adjc>=0 && adjc<m;
    }

    public static List<Integer> numOfIslands(int n, int m, int[][] A) {
        Disjoint4 ds = new Disjoint4(n*m);
        int[][] vis = new int[n][m];
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        for (int i = 0; i < A.length; i++) {
            int row = A[i][0];
            int col = A[i][1];

            if (vis[row][col] == 1) {
                ans.add(cnt);
                continue;
            }

            vis[row][col] = 1;
            cnt++;

            int newNode = row * m + col;

            for (int j = 0; j < 4; j++) {
                int adjr = row + dr[j];
                int adjc = col + dc[j];

                if (isValid(adjr,adjc,n,m) && vis[adjr][adjc]==1) {
                    int adjNewNode = adjr * m + adjc;
                    if (ds.findParent(newNode)!=ds.findParent(adjNewNode)) {
                        cnt--;
                        ds.unionBySize(newNode, adjNewNode);
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int q = in.nextInt();

            int[][] A = new int[q][2];
            for (int i = 0; i < q; i++) {
                A[i][0] = in.nextInt();
                A[i][1] = in.nextInt();
            }

            List<Integer> ans = numOfIslands(n,m,A);
            System.out.println(ans);
        }
    }
}
