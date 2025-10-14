import java.util.*;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length,i=0;
        List<int[]> res = new ArrayList<>();

        while (i<n && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }

        while(i<n && intervals[i][0] < newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        while (i<n){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-->0){
            int n = in.nextInt();
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = in.nextInt();
                intervals[i][1] = in.nextInt();
            }
            int[] newInterval = new int[2];
            newInterval[0] = in.nextInt();
            newInterval[1] = in.nextInt();

            int[][] ans = insert(intervals,newInterval);
           for(int[] interval: ans){
               System.out.println(interval[0] + " " + interval[1]);
           }
        }
    }
}
