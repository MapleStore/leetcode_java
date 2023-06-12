package darren.gong.leetcode;

import java.util.Arrays;
import java.util.Collections;

public class MaxHeight_1691 {
  public int maxHeight(int[][] cuboids) {
    int length = cuboids.length;
    for (int[] cuboid : cuboids) {
      Arrays.sort(cuboid);
      int temp = cuboid[0];
      cuboid[0] = cuboid[2];
      cuboid[2] = temp;
    }
    Arrays.sort(cuboids, (a,b)->{
      if (a[0] != b[0]) {
        return b[0]-a[0];
      }
      if (a[1] != b[1]) {
        return b[1]-a[1];
      }
      return b[2]-a[2];
    });
    int[] dp = new int[length];
    dp[0] = cuboids[0][0];
    for (int i = 1; i < length; i++) {
      dp[i] = cuboids[i][0];
      for (int j = i-1; j >= 0; j--) {
        if (cuboids[i][1] <= cuboids[j][1] && cuboids[i][2] <= cuboids[j][2]) {
          dp[i] = Math.max(dp[i], dp[j]+cuboids[i][0]);
        }
      }
    }
    return Arrays.stream(dp).max().getAsInt();
  }
}
