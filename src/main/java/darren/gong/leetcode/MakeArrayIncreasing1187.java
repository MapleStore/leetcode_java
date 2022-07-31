package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MakeArrayIncreasing1187 {
  public static void main(String[] args) {
    MakeArrayIncreasing1187 makeArrayIncreasing1187 = new MakeArrayIncreasing1187();
    makeArrayIncreasing1187.makeArrayIncreasing(new int[]{0,11,6,1,4,3}, new int[]{5,4,11,10,1,0});
  }
  public int makeArrayIncreasing(int[] arr1, int[] arr2) {
    int arr1Length = arr1.length;
    Set<Integer> single = new HashSet<>();
    for (int num : arr2) {
      single.add(num);
    }
    List<Integer> singleList = new ArrayList<>(single);
    Collections.sort(singleList);
    int arr2Length = singleList.size();
    // 前i个数 第i个数和第j个数替换最小值
    int[][] dp = new int[arr1Length+1][arr2Length+1];
    int[] min = new int[arr2Length+1];
    min[0] = 9999;
    for (int i = 1; i <= arr1Length; i++) {
      int currentMin = 9999;
      int[] nextMin = new int[arr2Length+1];
      nextMin[0] = 9999;
      for (int j = 0; j <= arr2Length; j++) {
        if (i == 1 && j == 0) {
          dp[i][j] = 0;
          continue;
        } else if (i == 1) {
          dp[i][j] = 1;
          nextMin[j] = 1;
          continue;
        }

        dp[i][j] = 9999;
        if (j == 0) {
          for (int k = 1; k <= arr2Length; k++) {
            if (arr1[i-1] > singleList.get(k-1)) {
              dp[i][j] = Math.min(dp[i][j], dp[i-1][k]);
            }
          }
          if (arr1[i-1] > arr1[i-2]) {
            dp[i][j] = Math.min(dp[i][j], dp[i-1][0]);
          }
          continue;
        }

        if (j != 1) {
          dp[i][j] = min[j-1]+1;
        }
        if (singleList.get(j-1) > arr1[i-2]) {
          dp[i][j] = Math.min(dp[i][j], dp[i-1][0]+1);
        }
        currentMin = Math.min(currentMin, dp[i][j]);
        nextMin[j] = currentMin;
      }
      min = nextMin;
    }
    int result = Integer.MAX_VALUE;
    for (int j = 0; j <= arr2Length; j++) {
      result = Math.min(result, dp[arr1Length][j]);
    }
    return result < 9999 ? result : -1;
  }
}
