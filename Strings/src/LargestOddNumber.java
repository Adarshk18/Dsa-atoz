import java.util.*;

public class LargestOddNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());

        while (t-->0){
            String s = in.nextLine();
            int n = s.length();
            boolean found = false;

            for (int i = n-1; i >= 0; i--) {
                if ((s.charAt(i)-'0')%2!=0){
                    System.out.println(s.substring(0,i+1));
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("");
            }
        }
    }
}
