import java.util.*;

public class MaximalRectangles {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()]>heights[i]){
                int element = st.peek();
                st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1: st.peek();

                maxArea = Math.max(maxArea,heights[element]*(nse-pse-1));
            }
            st.push(i);
        }
        while (!st.isEmpty()){
            int nse = n;
            int element = st.peek();
            st.pop();
            int pse = st.isEmpty() ? -1 : st.peek();

            maxArea = Math.max(maxArea,heights[element]*(nse-pse-1));
        }
        return maxArea;

    }
    public static int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int maxArea =0;
        int[][] prefSum = new int[n][m];
        for (int j = 0; j < m; j++) {
            int sum =0;
            for (int i = 0; i < n; i++) {
                sum += matrix[i][j] - '0';
                if (matrix[i][j]=='0') sum =0;

                prefSum[i][j] = sum;
            }
        }
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea,largestRectangleArea(prefSum[i]));
        }
        return maxArea;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-->0){
            int n = in.nextInt();
            int m = in.nextInt();

            in.nextLine();

            char[][] matrix = new char[n][m];
            for (int i = 0; i < n; i++) {
                String line = in.nextLine().replaceAll("\\s","");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = line.charAt(j);
                }
            }

            System.out.println("[" + "[" +maximalRectangle(matrix) +"]" + "]");
        }
    }
}
