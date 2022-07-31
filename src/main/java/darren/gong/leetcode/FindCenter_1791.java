package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindCenter_1791 {
  // 1791. 找出星型图的中心节点
  public int findCenter(int[][] edges) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int[] edge : edges) {
      int from = edge[0];
      int to = edge[1];
      int fromNum = map.getOrDefault(from, 0);
      if (fromNum > 0) {
        return from;
      }
      map.put(from, 1);

      int toNum = map.getOrDefault(to, 0);
      if (toNum > 0) {
        return to;
      }
      map.put(to, 1);
    }
    return -1;
  }
}
