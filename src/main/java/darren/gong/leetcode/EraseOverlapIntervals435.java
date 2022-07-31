package darren.gong.leetcode;

import java.util.Arrays;

public class EraseOverlapIntervals435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->(a[1]-b[1]));
        int result = 0;
        int lastEnd = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[0] >= lastEnd) {
                result++;
                lastEnd = interval[1];
            }
        }
        return intervals.length - result;
    }
}
