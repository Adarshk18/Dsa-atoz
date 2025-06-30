<<<<<<< HEAD
import java.util.*;

public class Zfunction {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());

        while (t-->0){
            String haystack = in.nextLine();
            String needle = in.nextLine();

            if(needle.isEmpty()) System.out.println(0);

            for (int i = 0; i <= haystack.length() - needle.length(); i++) {
                if (haystack.substring(i,i+needle.length()).equals(needle)){
                    System.out.println(i);
                }
            }
            System.out.println(-1);
        }
    }
}
=======
import java.util.*;

public class Zfunction {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());

        while (t-->0){
            String haystack = in.nextLine();
            String needle = in.nextLine();

            if(needle.isEmpty()) System.out.println(0);

            for (int i = 0; i <= haystack.length() - needle.length(); i++) {
                if (haystack.substring(i,i+needle.length()).equals(needle)){
                    System.out.println(i);
                }
            }
            System.out.println(-1);
        }
    }
}
>>>>>>> d8e3d28518b0d49bdef3a39a4e39d1856512497d
