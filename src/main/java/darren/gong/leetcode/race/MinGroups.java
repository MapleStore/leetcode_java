package darren.gong.leetcode.race;

import java.util.Arrays;
import java.util.TreeMap;

public class MinGroups {
  public int minGroups(int[][] intervals) {
    Arrays.sort(intervals, (a,b)->{
      if (a[0] == b[0]) {
        return a[1]-b[1];
      } else {
        return a[0]-b[0];
      }
    });
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    for (int[] interval : intervals) {
      int start = interval[0];
      int end = interval[1];
      Integer groupEnd = treeMap.lowerKey(start);
      if (groupEnd == null) {
        treeMap.put(end, treeMap.getOrDefault(end, 0)+1);
        continue;
      }
      int groupCount = treeMap.get(groupEnd);
      if (groupCount == 1) {
        treeMap.remove(groupEnd);
      } else {
        treeMap.put(groupEnd, groupCount-1);
      }
      treeMap.put(end, treeMap.getOrDefault(end, 0)+1);
    }
    int result = 0;
    for (int count : treeMap.values()) {
      result += count;
    }
    return result;
  }
}
