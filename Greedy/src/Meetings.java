import java.util.*;

public class Meetings {
    static class Meeting{
        int start,end,pos;

        Meeting(int start, int end, int pos){
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    static class meetingComparator implements Comparator<Meeting>{
        @Override
        public int compare(Meeting o1, Meeting o2) {
            if (o1.end != o2.end)
                return Integer.compare(o1.end, o2.end);  // ascending order by end time
            return Integer.compare(o1.pos, o2.pos);
        }
    }
    static void maxMeetings(int start[], int end[], int n) {
        ArrayList<Meeting> meet = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            meet.add(new Meeting(start[i],end[i],i+1));
        }
        Collections.sort(meet,new meetingComparator()); //sorting on the basis of end time.
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(meet.get(0).pos);
        int freeTime = meet.get(0).end;
        int cnt = 1;


        for (int i = 1; i < n; i++) {
            if (meet.get(i).start >= freeTime){
                ans.add(meet.get(i).pos);
                freeTime = meet.get(i).end;
                cnt++;
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println("\n" + cnt);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-->0){
            int n = in.nextInt();

            int[] start = new int[n];
            int[] end = new int[n];
            for (int i = 0; i < n; i++) {
                start[i] = in.nextInt();
                end[i] = in.nextInt();
            }
            maxMeetings(start,end,n);
        }
    }
}
