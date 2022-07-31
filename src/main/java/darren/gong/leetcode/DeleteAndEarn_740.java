package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn_740 {
  // 740. 删除并获得点数
  public static void main(String[] args) {
    DeleteAndEarn_740 deleteAndEarn_740 = new DeleteAndEarn_740();
    deleteAndEarn_740.deleteAndEarn(new int[]{3,4,2});
  }
  public int deleteAndEarn(int[] nums) {
    int max = Integer.MIN_VALUE;
    for (int num : nums) {
      max = Math.max(max, num);
    }
    int[] newNums = new int[max+1];
    for (int num : nums) {
      newNums[num] += num;
    }
    int result = Integer.MIN_VALUE;
    int[] dp = new int[max+1];
    for (int i = 0; i <= max; i++) {
      int one = i-1 >= 0 ? dp[i-1] : 0;
      int two = i-2 >= 0 ? dp[i-2] : 0;
      dp[i] = Math.max(newNums[i]+two, one);
    }
    return dp[max];
  }

  // timeout
  public int deleteAndEarn2(int[] nums) {
    Map<Integer, Integer> numCount = new HashMap<>();
    for (int num : nums) {
      numCount.put(num, numCount.getOrDefault(num, 0)+num);
    }
    nums = new int[numCount.size()];
    int index = 0;
    for (int key : numCount.keySet()) {
      nums[index] = key;
      index++;
    }
    Arrays.sort(nums);
    int length = nums.length;
    int[][] dp = new int[length][length];
    for (int distance = 1; distance <= length; distance++) {
      for (int start = 0; start+distance-1 < length; start++) {
        int end = start+distance-1;
        if (start == end) {
          dp[start][end] = numCount.get(nums[start]);
          continue;
        }
        for (int currentIndex = start; currentIndex <= end; currentIndex++) {
          int leftVal = 0;
          if (currentIndex-1 >= start && nums[currentIndex-1] < nums[currentIndex]-1) {
            leftVal = dp[start][currentIndex-1];
          } else if (currentIndex-2 >= start) {
            leftVal = dp[start][currentIndex-2];
          }
          int rightVal = 0;
          if (currentIndex+1 <= end && nums[currentIndex+1] > nums[currentIndex]+1) {
            rightVal = dp[currentIndex+1][end];
          } else if (currentIndex+2 <= end) {
            rightVal = dp[currentIndex+2][end];
          }
          dp[start][end] = Math.max(dp[start][end], numCount.get(nums[currentIndex])+leftVal+rightVal);
        }
      }
    }
    return dp[0][length-1];
  }
}
