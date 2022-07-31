package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsReflected356 {
  public static void main(String[] args) {
    IsReflected356 isReflected356 = new IsReflected356();
    isReflected356.isReflected(new int[][]{{1,2},{2,2},{1,4},{2,4}});
  }
  public boolean isReflected(int[][] points) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int[] point : points) {
      max = Math.max(max, point[0]);
      min = Math.min(min, point[0]);
    }
    double mid = ((double)max+(double)min)/2;
    Map<Double, Set<Integer>> contains = new HashMap<>();
    for (int[] point : points) {
      Set<Integer> ys = contains.get((double)point[0]);
      if (ys == null) {
        ys = new HashSet<>();
        contains.put((double)point[0], ys);
      }
      ys.add(point[1]);
    }
    for (int[] point : points) {
      if (point[0] == mid) {
        continue;
      }
      double reflect = 2*mid-point[0];
      Set<Integer> ys = contains.get(reflect);
      if (ys == null || !ys.contains(point[1])) {
        return false;
      }
    }
    return true;
  }
}
