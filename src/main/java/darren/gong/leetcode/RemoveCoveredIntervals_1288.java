package darren.gong.leetcode;

import java.util.Arrays;

public class RemoveCoveredIntervals_1288 {
  public int removeCoveredIntervals(int[][] intervals) {
    int length = intervals.length;
    Arrays.sort(intervals, (a,b)->{
      if (a[0] == b[0]) {
        return b[1]-a[1];
      } else {
        return a[0]-b[0];
      }
    });
    boolean[] covered = new boolean[length];
    for (int i = 0; i < length-1; i++) {
      if (covered[i]) {
        continue;
      }
      int[] current = intervals[i];
      int coveredIndex = i+1;
      while (coveredIndex < length && current[1] >= intervals[coveredIndex][1]) {
        covered[coveredIndex] = true;
        coveredIndex++;
      }
    }
    int result = 0;
    for (int i = 0; i < length; i++) {
      if (covered[i]) {
        result++;
      }
    }
    return length-result;
  }
}
