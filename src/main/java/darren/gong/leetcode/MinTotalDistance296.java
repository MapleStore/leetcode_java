package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinTotalDistance296 {
  public int minTotalDistance(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
      return -1;
    }
    int maxX = grid.length;
    int maxY = grid[0].length;
    List<Integer> allX = new ArrayList<>();
    List<Integer> allY = new ArrayList<>();
    for (int i = 0; i < maxX; i++) {
      for (int j = 0; j < maxY; j++) {
        if (grid[i][j] == 1) {
          allX.add(i);
          allY.add(j);
        }
      }
    }

    Collections.sort(allX);
    Collections.sort(allY);
    int result = 0;
    int left = 0;
    int right = allX.size()-1;
    while (left < right) {
      result += allX.get(right)-allX.get(left);
      left++;
      right--;
    }
    int up = 0;
    int down = allY.size()-1;
    while (up < down) {
      result += allY.get(down)-allY.get(up);
      up++;
      down--;
    }
    return result;
  }
}
