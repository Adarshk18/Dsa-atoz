import java.util.*;

public class LongestPrefix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());

        while (t-->0){
            int n = Integer.parseInt(in.nextLine());
            String[] s = new String[n];
            for (int i = 0; i < n; i++) {
                s[i] = in.nextLine().trim();
            }

            String prefix = s[0];
            for (int i = 1; i < s.length; i++) {
                if (!s[i].startsWith(prefix)){
                    prefix = prefix.substring(0, prefix.length()-1);
                    if (prefix.isEmpty()) break;
                }
            }
            System.out.println(prefix.isEmpty() ? "": prefix);

        }
        in.close();
    }
}
