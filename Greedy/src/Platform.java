import java.util.*;

public class Platform {

    public static int findPlatform(int[] Arrival, int[] Departure) {
        //your code goes here
        Arrays.sort(Arrival);
        Arrays.sort(Departure);

        int cnt =1, maxCnt =1;
        int i=1,j=0;

        while (i<Arrival.length && j< Departure.length){
            if (Arrival[i] <= Departure[j]){
                cnt++;
                i++;
            } else if (Arrival[i] > Departure[j]) {
                cnt--;
                j++;
            }

            if (cnt > maxCnt){
                maxCnt = cnt;
            }
        }
        return maxCnt;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-->0){
            int n = in.nextInt();
            int[] Arrival = new int[n];
            int[] Departure = new int[n];
            for (int i = 0; i < n; i++) {
                Arrival[i] = in.nextInt();
                Departure[i] = in.nextInt();
            }

            int cnt = findPlatform(Arrival,Departure);
            System.out.println(cnt);
        }
    }
}
