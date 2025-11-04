import java.util.*;

public class LPS {

    public static int LCS(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1-1)==s2.charAt(ind2-1)){
                    curr[ind2] = 1+prev[ind2-1];
                }else{
                    curr[ind2] = Math.max(prev[ind2],curr[ind2-1]);
                }

            }
            prev = curr;
        }
        return prev[m];
    }
    public static int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        return LCS(s,rev);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); in.nextLine();

        while (t-->0){
            String text1 = in.next();

            int res = longestPalindromeSubseq(text1);
            System.out.println(res);
        }
    }
}
