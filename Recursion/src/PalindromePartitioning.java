import java.util.*;

public class PalindromePartitioning {

    public static boolean isPalindrome(String s,int start, int end){
        while(start<=end){
            if (s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }

    public static void partition1(int ind, String s, List<String> path, List<List<String>> res){
        if (ind==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = ind; i < s.length(); i++) {
            if (isPalindrome(s,ind,i)){
                path.add(s.substring(ind,i+1));
                partition1(i+1,s,path,res);
                path.remove(path.size()-1);
            }
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        partition1(0,s,path,res);
        return res;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();

        while(t-->0){
            String s = in.nextLine();

            PalindromePartitioning pl = new PalindromePartitioning();
            List<List<String>> res = pl.partition(s);
            System.out.println(res);
        }
    }
}
