package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumIncompatibility_1681 {
  private Map<Integer, Integer> map = new HashMap<>();
  public int minimumIncompatibility(int[] nums, int k) {
    int length = nums.length;
    int eachPoolSize = length/k;
    int[] subIncompatibilities = new int[1<<length];
    Arrays.fill(subIncompatibilities, -1);
    int[] repeatPositions = new int[length+1];
    // 数字nums[i]所在的所有位置
    for (int i = 0; i < length; i++) {
      repeatPositions[nums[i]] |= (1<<i);
    }
    for (int sub = 0; sub < (1<<length); sub++) {
      if (countOne(sub) != eachPoolSize || haveRepeat(repeatPositions, sub)) {
        continue;
      }
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      for (int pos = 0; pos < length; pos++) {
        if ((sub & (1<<pos)) != 0) {
          min = Math.min(min, nums[pos]);
          max = Math.max(max, nums[pos]);
        }
      }
      subIncompatibilities[sub] = max-min;
    }

    int[] dp = new int[1<<length];
    Arrays.fill(dp, -1);
    dp[0] = 0;
    for (int mask = 0; mask < (1<<length); mask++) {
      if (countOne(mask)%eachPoolSize != 0) {
        continue;
      }
      for (int sub = mask; sub > 0; sub = (sub-1)&mask) {
        if (subIncompatibilities[sub] == -1 || dp[mask^sub] == -1) {
          continue;
        }
        if (dp[mask] == -1) {
          dp[mask] = subIncompatibilities[sub]+dp[mask^sub];
        } else {
          dp[mask] = Math.min(dp[mask], subIncompatibilities[sub]+dp[mask^sub]);
        }
      }
    }
    return dp[(1<<length)-1];

  }

  private int getLowBit1(int val) {
    return val&-val;
  }

  private int countOne(int val) {
    int result = 0;
    while (val!=0) {
      val -= getLowBit1(val);
      result++;
    }
    return result;
  }

  private boolean haveRepeat(int[] repeatPositions, int val) {
    for (int repeatPosition : repeatPositions) {
      int temp = val&repeatPosition;
      if (temp == 0) {
        continue;
      }
      if (temp-getLowBit1(temp) > 0) {
        return true;
      }
    }
    return false;
  }

}
