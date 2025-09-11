import java.util.*;


public class wordLadder2 {

    static class comp implements Comparator <List<String>>{
        public int compare(List<String> a , List<String> b){
            String x = "";
            String y = "";
            for (int i = 0; i < a.size(); i++) {
                x += a.get(i);
            }
            for (int i = 0; i < b.size(); i++) {
                y += b.get(i);
            }
            return x.compareTo(y);
        }
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>(wordList);
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        ls.add(beginWord);
        q.add(ls);
        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);
        int level = 0;

        List<List<String>> ans = new ArrayList<>();
        int cnt =0;

        while (!q.isEmpty()){
            cnt++;
            ArrayList<String> vec = q.peek();
            q.remove();

            if (vec.size()>level){
                level++;

                for(String it: usedOnLevel){
                    st.remove(it);
                }
                usedOnLevel.clear();
            }

            String word = vec.get(vec.size()-1);

            if (word.equals(endWord)){
                if (ans.size()==0){
                    ans.add(vec);
                }else if (ans.get(0).size()==vec.size()){
                    ans.add(vec);
                }
            }

            for (int i = 0; i < word.length(); i++) {
                for(char c='a'; c<='z'; c++){
                    if (c == word.charAt(i)) continue;

                    char[] replacementArray = word.toCharArray();
                    replacementArray[i] = c;

                    String replacedWord = new String(replacementArray);
                    if (st.contains(replacedWord)){
                        vec.add(replacedWord);

                        q.add(new ArrayList<>(vec));

                        usedOnLevel.add(replacedWord);
                        vec.remove(vec.size()-1);
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            String beginWord = in.next();
            String endWord = in.next();

            int n = in.nextInt();
            List<String> wordList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                wordList.add(in.next());
            }

            List<List<String>> ans = findLadders(beginWord,endWord,wordList);
            if (ans.size()==0){
                System.out.println(-1);
            }else{
                Collections.sort(ans,new comp());
                for (int i = 0; i < ans.size(); i++) {
                    for (int j = 0; j < ans.get(i).size(); j++) {
                        System.out.print(ans.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
            }

        }
    }
}
