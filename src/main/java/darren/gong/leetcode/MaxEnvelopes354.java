package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MaxEnvelopes354 {
  public static void main(String[] args) {
    MaxEnvelopes354 maxEnvelopes354 = new MaxEnvelopes354();
    maxEnvelopes354.maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}});
  }
  public int maxEnvelopes(int[][] envelopes) {
    if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) {
      return 0;
    }
    int length = envelopes.length;
    Arrays.sort(envelopes, (a,b)->{
      if (a[0] == b[0]) {
        return b[1]-a[1];
      } else {
        return a[0]-b[0];
      }
    });

    int[] heights = new int[length];
    for (int i = 0; i < length; i++) {
      heights[i] = envelopes[i][1];
    }
    return maxIncreaseLength(heights);
  }

  private int maxIncreaseLength(int[] heights) {
    if (heights == null || heights.length == 0) {
      return 0;
    }
    int length = heights.length;
    int[] dp = new int[length];
    for (int i = 0; i < length; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (heights[i] > heights[j]) {
          dp[i] = Math.max(dp[i], dp[j]+1);
        }
      }
    }
    return Arrays.stream(dp).max().getAsInt();
  }
}
