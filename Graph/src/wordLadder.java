import java.util.*;

public class wordLadder {

    static class Pair{
        String first;
        int second;

        Pair(String first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        Set<String> st = new HashSet<>(wordList);

        st.remove(beginWord);
        while (!q.isEmpty()){
            String word = q.peek().first;
            int step = q.peek().second;
            q.remove();

            if (word.equals(endWord)) return step;

            for (int i = 0; i < word.length(); i++) {
                for(char ch='a'; ch<='z'; ch++){
                    char[] replacementArray = word.toCharArray();
                    replacementArray[i] = ch;

                    String replaceWord = new String(replacementArray);
                    if (st.contains(replaceWord)){
                        st.remove(replaceWord);
                        q.add(new Pair(replaceWord,step+1));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-->0){
            String beginWord = in.next();
            String endWord = in.next();

            int n = in.nextInt();
            List<String> wordList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                wordList.add(in.next());
            }

            int cnt = ladderLength(beginWord,endWord,wordList);
            System.out.println(cnt);
        }
    }
}
