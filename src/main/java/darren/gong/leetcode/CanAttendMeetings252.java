package darren.gong.leetcode;

import java.util.Arrays;

public class CanAttendMeetings252 {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        int end = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[0] < end) {
                return false;
            }
            end = interval[1];
        }
        return true;
    }
}
