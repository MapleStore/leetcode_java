package darren.gong.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MinNumofArrowsBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        int result = 0;
        if (points.length <= 0) {
            return result;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        result = 1;
        int nowEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > nowEnd) {
                result++;
                nowEnd = points[i][1];
            }
        }
        return result;
    }

}
