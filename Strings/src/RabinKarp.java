import java.util.*;

public class RabinKarp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());

        while (t-->0){
            String a = in.nextLine();
            String b = in.nextLine();

            StringBuilder repeated = new StringBuilder(a);
            int cnt =1;

            //check if a length is atleast as long as b length
            while (repeated.length()<b.length()){
                repeated.append(a);
                cnt++;
            }

            //if current repeated string contains b or not
            if (repeated.toString().contains(b)){
                System.out.println(cnt);
                continue;
            }

            repeated.append(a);
            cnt++;

            if (repeated.toString().contains(b)){
                System.out.println(cnt);
            }else{
                System.out.println(-1);
            }

        }

    }
}
