import java.util.Arrays;
import java.util.Scanner;

public class DeleteString {

    public static int LCS(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1-1) == s2.charAt(ind2-1)) {
                    curr[ind2] = 1 + prev[ind2 - 1];

                } else {
                    curr[ind2] = Math.max(prev[ind2], curr[ind2 - 1]);
                }
            }
            prev = Arrays.copyOf(curr, curr.length);
        }
        return prev[m];
    }

    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        return n + m - 2 * LCS(word1, word2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();

        while (t-- > 0) {
            String text1 = in.next();
            String text2 = in.next();

            int min = minDistance(text1,text2);

            System.out.println(min);
        }
    }
}
