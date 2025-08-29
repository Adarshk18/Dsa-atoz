import java.util.*;

public class ShortestPalindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = Integer.parseInt(in.nextLine());

        while (t-->0){
            String s = in.nextLine();

            if (s==null || s.length()<1)
                System.out.println(s);

            String rev = new StringBuilder(s).reverse().toString();
            String combined = s + '#' + rev;

            int[] lps = new int[combined.length()];

            for (int i = 1; i < combined.length(); i++) {

                int j = lps[i-1];

                while (j>0 && combined.charAt(i)!=combined.charAt(j)){
                    j = lps[j-1];
                }

                if (combined.charAt(i)==combined.charAt(j)){
                    j++;
                }
                lps[i] = j;

            }

            int toAdd = s.length() - lps[combined.length()-1];
            String prefix = new StringBuilder(s.substring(s.length()-toAdd)).reverse().toString();

            System.out.println(prefix+s);
        }
    }
}
