package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxNonOverlapping_1546 {
  // 1546. 和为目标值的最大数目不重叠非空子数组数目
  public static void main(String[] args) {
    MaxNonOverlapping_1546 maxNonOverlapping_1546 = new MaxNonOverlapping_1546();
    maxNonOverlapping_1546.maxNonOverlapping(new int[]{2,-2,1,3}, 2);
  }
  public int maxNonOverlapping(int[] nums, int target) {
    Map<Integer, Integer> valueToIndex = new HashMap<>();
    int length = nums.length;
    int[] newNums = new int[length+1];
    for (int i = 1; i <= length; i++) {
      newNums[i] = newNums[i-1]+nums[i-1];
    }
    int result = 0;
    int nowEndIndex = -100;
    for (int i = 0; i <= length; i++) {
      Integer index = valueToIndex.get(newNums[i]-target);
      if (index != null && index >= nowEndIndex) {
        result++;
        nowEndIndex = i;
      }
      valueToIndex.put(newNums[i], i);
    }
    return result;
  }
}
