import java.util.*;

public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        for (int j = 0; j <= m; j++) {
            prev[j] = j;
        }

        for (int i = 1; i <= n; i++) {
            curr[0] = i;
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    curr[j] = prev[j-1];
                }else{
                    curr[j] = 1 + Math.min(prev[j-1],Math.min(prev[j],curr[j-1]));
                }
            }
            prev = curr;
            curr = new int[m + 1];
        }
        return prev[m];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            String s = in.next();
            String u = in.next();

            int result = minDistance(s, u);
            System.out.println(result);
        }
    }
}
