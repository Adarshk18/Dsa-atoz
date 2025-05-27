import java.util.*;


public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t= Integer.parseInt(in.nextLine());

        while(t-->0){
            String s = in.nextLine();
            int dict = Integer.parseInt(in.nextLine());
            List<String> wordDict = new ArrayList<>();
            for (int i = 0; i < dict; i++) {
                wordDict.add(in.nextLine());
            }

            boolean res = wordBreak(s,wordDict);
            System.out.println(res);
        }
    }
}
