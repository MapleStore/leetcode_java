package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Insert57 {
  public static void main(String[] args) {
    Insert57 insert57 = new Insert57();
    insert57.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}},
        new int[]{4,8});
  }
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> tempResult = new LinkedList<>();
    int intervalIndex = 0;
    boolean newIntervalVisit = false;
    int start;
    int end;
    if (intervals == null || intervals.length == 0) {
      if (newInterval == null || newInterval.length == 0) {
        return new int[0][0];
      } else {
        start = newInterval[0];
        end = newInterval[1];
      }
    } else if (newInterval == null || newInterval.length == 0) {
      start = intervals[0][0];
      end = intervals[0][1];
      intervalIndex++;
      newIntervalVisit = true;
    } else {
      if (newInterval[0] < intervals[0][0]) {
        start = newInterval[0];
        end = newInterval[1];
        newIntervalVisit = true;
      } else {
        start = intervals[0][0];
        end = intervals[0][1];
        intervalIndex++;
      }
    }

    while (intervalIndex < intervals.length || !newIntervalVisit) {
      int[] next = null;
      if (newIntervalVisit) {
        next = intervals[intervalIndex];
        intervalIndex++;
      } else if (intervalIndex >= intervals.length) {
        next = newInterval;
        newIntervalVisit = true;
      } else {
        if (intervals[intervalIndex][0] < newInterval[0]) {
          next = intervals[intervalIndex];
          intervalIndex++;
        } else {
          next = newInterval;
          newIntervalVisit = true;
        }
      }
      if (next[0] > end) {
        tempResult.add(new int[]{start, end});
        start = next[0];
      }
      end = Math.max(end, next[1]);
    }
    tempResult.add(new int[]{start, end});
    int[][] result = new int[tempResult.size()][2];
    int index = 0;
    for (int[] one : tempResult) {
      result[index++] = one;
    }
    return result;
  }
}
