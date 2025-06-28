import java.io.*;
import java.util.*;

public class Atoi {

    public static int atoi(String s){
        int i =0, sign = 1, result =0;
        int n = s.length();


        //skipping white spaces
        while(i<n && s.charAt(i)==' '){
            i++;
        }

        //checking the signs
        while(i<n && (s.charAt(i)=='+' || s.charAt(i)=='-')){
            sign = (s.charAt(i)=='-') ? -1: 1;
        }

        // 3. Convert digits and stop at non-digit character
        while (i<n && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';

            if (result > (Integer.MAX_VALUE-digit)/10){
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = Integer.parseInt(in.nextLine());
        while(t-->0){
            String s = in.nextLine();
            System.out.println(atoi(s));;
        }
    }
}
