package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class LongestWPI_1124 {
  // 1124. 表现良好的最长时间段
  public static void main(String[] args) {
    LongestWPI_1124 longestWPI_1124 = new LongestWPI_1124();
    longestWPI_1124.longestWPI(new int[]{9,9,9});
  }
  public int longestWPI(int[] hours) {
    int length = hours.length;
    for (int i = 0; i < length; i++) {
      hours[i] = hours[i] > 8 ? 1 : -1;
    }
    for (int i = 1; i < length; i++) {
      hours[i] += hours[i-1];
    }

    TreeSet<int[]> treeSet = new TreeSet<>((a,b)->{
      if (a[0] == b[0]) {
        return b[1]-a[1];
      } else {
        return a[0]-b[0];
      }
    });
    int result = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < length; i++) {
      if (hours[i] > 0) {
        result = i+1;
        continue;
      }
      result = Math.max(result, i-map.getOrDefault(hours[i]-1, Integer.MAX_VALUE));
      if (!map.containsKey(hours[i])) {
        map.put(hours[i], i);
      }
    }
    return result;
  }
}
