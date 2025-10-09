import java.util.*;

public class AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        int l=0,r=0;
        while (l<n && r<m){
            if (s[r]>=g[l]){
                l++;
            }
            r++;
        }
        return l;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-->0){
            int n = in.nextInt();
            int m = in.nextInt();
            int[] g = new int[n];
            for (int i = 0; i < n; i++) {
                g[i] = in.nextInt();
            }


            int[] s = new int[m];
            for (int i = 0; i < m; i++) {
                s[i] = in.nextInt();
            }

            int ans = findContentChildren(g,s);
            System.out.println(ans);

        }
    }
}
