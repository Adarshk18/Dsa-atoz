import java.util.*;

public class Cookies {

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int n = g.length;
        int m = s.length;

        int r = 0, l = 0;


        while (r<n && l < m) {
            if (g[r] <= s[l]) {
                r++;
            }
            l++;
        }
        return r;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] g = new int[n];
            for (int i = 0; i < n; i++) {
                g[i] = in.nextInt();
            }

            int m = in.nextInt();
            int[] s = new int[m];
            for (int i = 0; i < m; i++) {
                s[i] = in.nextInt();
            }

            int ans = findContentChildren(g, s);
            System.out.println(ans);
        }
    }
}
