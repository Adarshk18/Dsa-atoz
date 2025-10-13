import java.util.*;

public class Candy {
    public static  int candy(int[] ratings) {
        int n = ratings.length;

        int sum =n, i=1;

        while (i<n){
            //flat
            if (ratings[i] == ratings[i-1]){
                i++;
                continue;
            }

            //peak
            int peak =0;
            while (i<n && ratings[i] > ratings[i-1]){
                peak++;
                sum += peak;
                i++;
            }

            //down
            int down = 0;
            while (i<n && ratings[i]<ratings[i-1]){
                down++;
                sum += down;
                i++;

            }
            sum -= Math.min(peak,down);
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-->0){
            int n = in.nextInt();
            int[] ratings = new int[n];
            for (int i = 0; i < n; i++) {
                ratings[i] = in.nextInt();
            }

            int cnt = candy(ratings);
            System.out.println(cnt);
        }
    }
}
