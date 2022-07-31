package darren.gong.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;
        if (intervals.length <= 0) {
            return result;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int nowEnd = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] < nowEnd) {
                result++;
            } else {
                nowEnd = intervals[i][1];
            }
        }
        return result;
    }

}
