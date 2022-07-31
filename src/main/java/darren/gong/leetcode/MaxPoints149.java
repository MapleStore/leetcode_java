package darren.gong.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxPoints149 {
  public static void main(String[] args) {
    MaxPoints149 maxPoints149 = new MaxPoints149();
    maxPoints149.maxPoints(new int[][]{{1,1},{2,1},{2,2},{1,4},{3,3}});
  }
  public int maxPoints(int[][] points) {
    if (points == null) {
      return 0;
    }
    Map<String, Set<String>> map = new HashMap<>();
    int length = points.length;
    if (length <= 1) {
      return length;
    }
    int result = 0;
    Map<String, Integer> values = new HashMap<>();
    for (int i = 0; i < length; i++) {
      int value = values.getOrDefault(getPoint(points[i]), 0)+1;
      result = Math.max(result, value);
      values.put(getPoint(points[i]), value);
    }

    length = points.length;
    for (int i = 0; i < length; i++) {
      for (int j = i+1; j < length; j++) {
        if (getPoint(points[i]).equals(getPoint(points[j]))) {
          continue;
        }
        String line = countLine(points[i], points[j]);
        if (!map.containsKey(line)) {
          map.put(line, new HashSet<>());
        }
        map.get(line).add(getPoint(points[i]));
        map.get(line).add(getPoint(points[j]));
      }
    }

    for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
      int tempResult = 0;
      for (String key : entry.getValue()) {
        tempResult += values.getOrDefault(key, 0);
      }
      result = Math.max(result, tempResult);
    }
    return result;
  }

  private String countLine(int[] point1, int[] point2) {
    int y = (point2[1]-point1[1]);
    int x = (point2[0]-point1[0]);
    if (x == 0) {
      return point2[0]+"";
    }

    int gcd = gcd(y, x);
    y = y/gcd;
    x = x/gcd;
    double b = (double) point1[1] - (double) y * (double) point1[0] / (double) x;
    return y+"@"+x+"@"+b;
  }
  private String getPoint(int[] point) {
    return point[0]+"@"+point[1];
  }
  private int gcd(int a, int b) {
    while (b != 0) {
      int temp = a % b;
      a = b;
      b = temp;
    }
    return a;
  }
}
