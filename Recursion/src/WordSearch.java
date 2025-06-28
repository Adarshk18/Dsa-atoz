import java.util.*;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        int ind = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(ind)){
                    if (search(board,word,i,j,ind))
                        return true;
                }
            }
        }
        return false;
    }

    private static boolean search(char[][] board, String word, int row, int col, int ind){
        if (ind==word.length()){
            return true;
        }

        if (row <0 || row>= board.length || col <0 || col>= board[0].length || board[row][col] != word.charAt(ind)){
            return false;
        }

        char c = board[row][col];
        board[row][col] = '#';

        boolean found = search(board,word,row-1,col,ind+1) || search(board,word,row,col+1,ind+1) || search(board,word,row+1,col,ind+1) || search(board,word,row,col-1,ind+1);


        board[row][col] = c;
        return found;

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();


        while(t-->0){
            int m = in.nextInt();
            int n = in.nextInt();


            char[][] board = new char[m][n];

            for (int i = 0; i < m; i++) {
                String row = in.next();
                for (int j = 0; j < n; j++) {
                    board[i][j] = row.charAt(j);
                }
            }

            String word = in.nextLine();

            WordSearch ws = new WordSearch();
            boolean res = ws.exist(board,word);
            System.out.println(res);
        }
    }
}
