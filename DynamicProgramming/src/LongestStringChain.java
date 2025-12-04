import java.util.*;

public class LongestStringChain {

    public static int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words,(a,b) -> a.length()-b.length());
        int[] dp = new int[n];
        Arrays.fill(dp,1);

        int maxi = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (checkPossible(words[i], words[j]) && dp[j]+1>dp[i]){
                    dp[i] = dp[j]+1;
                }
            }
            if (dp[i]>maxi){
                maxi = dp[i];
            }
        }
        return maxi;
    }

    public static boolean checkPossible(String s1, String s2){
        if (s1.length()!=s2.length()+1) return false;
        int i =0;
        int j=0;
        while (i<s1.length()){
            if (j<s2.length() && s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }
        return (i==s1.length() && j==s2.length());
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-->0){
            int n = in.nextInt();
            String[] word = new String[n];
            for (int i = 0; i < n; i++) {
                word[i] = in.next();
            }
            System.out.println(longestStrChain(word));
        }
    }
}
