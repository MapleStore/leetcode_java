package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GardenNoAdj_1042 {
  public static void main(String[] args) {
    GardenNoAdj_1042 gardenNoAdj_1042 = new GardenNoAdj_1042();
    gardenNoAdj_1042.gardenNoAdj(5,
        new int[][]{{4,1},{4,2},{4,3},{2,5},{1,2},{1,5}});
  }
  public int[] gardenNoAdj(int n, int[][] paths) {
    int[] colors = new int[n];
    Set<Integer>[] map = new Set[n+1];
    for (int i = 0; i <= n; i++) {
      map[i] = new HashSet<>();
    }
    for (int[] path : paths) {
      map[path[0]].add(path[1]);
      map[path[1]].add(path[0]);
    }

    int[][] order = new int[n+1][];
    for (int i = 0; i <= n; i++) {
      order[i] = new int[]{i, map[i].size()};
    }
    Arrays.sort(order, (a,b)->b[1]-a[1]);

    for (int index = 0; index <= n; index++) {
      int i = order[index][0];
      if (i == 0) {
        continue;
      }
      Set<Integer> next = map[i];
      boolean[] colorNotUse = new boolean[5];
      for (int closeGarden : next) {
        colorNotUse[colors[closeGarden-1]] = true;
      }
      for (int color = 1; color <= 4; color++) {
        if (!colorNotUse[color]) {
          colors[i-1] = color;
          break;
        }
      }
    }
    return colors;
  }
}
