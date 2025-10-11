import java.util.*;

public class ValidParenthesis {
    public static boolean checkValidString(String s) {
        //minOpen to count the minimum open br
        int minOpen = 0;
        //maxOpen to cnt  the max close br
        int maxOpen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c=='('){
                minOpen++;
                maxOpen++;
            }else if (c==')'){
                minOpen--;
                maxOpen--;
            }else{
                minOpen--;
                maxOpen++;
            }

            if (maxOpen<0) return false;

            if (minOpen<0) minOpen=0;
        }
        return minOpen==0;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); in.nextLine();

        while (t-->0){
            String input = in.nextLine();


            if (checkValidString(input)){
                System.out.println("true");
            }else{
                System.out.println(false);
            }
        }
    }
}
