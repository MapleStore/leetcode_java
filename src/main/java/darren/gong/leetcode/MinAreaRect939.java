package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MinAreaRect939 {
  public int minAreaRect(int[][] points) {
    if (points == null || points.length == 0 || points[0] == null || points[0].length == 0) {
      return 0;
    }
    Map<Integer, List<Integer>> lines = new TreeMap<>();
    int pointNum = points.length;
    for (int i = 0; i < pointNum; i++) {
      int x = points[i][0];
      int y = points[i][1];
      lines.putIfAbsent(x, new ArrayList<>());
      lines.get(x).add(y);
    }

    Map<Integer, Integer> map = new HashMap<>();
    int result = Integer.MAX_VALUE;
    for (Integer key : lines.keySet()) {
      List<Integer> line = lines.get(key);
      Collections.sort(line);
      int length = line.size();
      for (int y1Index = 0; y1Index < length; y1Index++) {
        for (int y2Index = y1Index+1; y2Index < length; y2Index++) {
          int y1 = line.get(y1Index);
          int y2 = line.get(y2Index);
          int yHash = y1*50000+y2;
          Integer preX = map.get(yHash);
          if (preX != null) {
            result = Math.min(result, (key-preX)*(y2-y1));
          }
          map.put(yHash, key);
        }
      }
    }
    return result == Integer.MAX_VALUE ? 0 : result;
  }
}
