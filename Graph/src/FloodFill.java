import java.util.*;

public class FloodFill {

    public static void dfs(int row, int col, int[][] ans, int[][] image, int iniColor, int[] delRow, int[] delCol, int newColor){
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;

        for (int i = 0; i < 4; i++) {
            int nr = row + delRow[i];
            int nc = col + delCol[i];

            if (nr>=0 && nr<n && nc>=0 && nc<m && image[nr][nc] == iniColor && ans[nr][nc]!=newColor){
                dfs(nr,nc,ans,image,iniColor,delRow,delCol,newColor);
            }
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor = image[sr][sc];
        int[][] ans = image;

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        dfs(sr,sc,ans,image,iniColor,delRow,delCol,color);
        return ans;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();

            int[][] image = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    image[i][j] = in.nextInt();
                }
            }

            int sr = in.nextInt();
            int sc = in.nextInt();
            int color = in.nextInt();

            int[][] ans = floodFill(image,sr,sc,color);
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }

        }

    }
}
