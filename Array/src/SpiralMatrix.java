import java.util.*;

public class SpiralMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] matrix = new int[n][m];


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }
            List<Integer> ans = new ArrayList<>();

            int top = 0,bottom=n-1,left=0,right=m-1;
            while (top<=bottom && left<=right){
                //moving from left to right in top
                for(int i=left; i<=right; i++){
                    ans.add(matrix[top][i]);
                }
                top++;

                //moving from top to bottom in right
                for(int i=top; i<=bottom; i++){
                    ans.add(matrix[i][right]);
                }
                right--;

                //moving from right to left in bottom
                if (top<=bottom){
                    for (int i = right; i >= left; i--) {
                        ans.add(matrix[bottom][i]);
                    }
                    bottom--;
                }

                //moving from bottom to top in left
                if (left<=right){
                    for (int i = bottom; i >= top; i--) {
                        ans.add(matrix[i][left]);
                    }
                    left++;
                }
            }

            System.out.print("[");
            for (int i = 0; i < ans.size(); i++) {
                    System.out.print(ans.get(i)+ ", ");
            }
            System.out.println("]");
        }

        in.close();
    }
}
