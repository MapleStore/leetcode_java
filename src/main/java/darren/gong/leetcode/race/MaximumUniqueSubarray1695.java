package darren.gong.leetcode.race;

import java.util.HashMap;
import java.util.Map;

public class MaximumUniqueSubarray1695 {
  public static void main(String[] args) {
    MaximumUniqueSubarray1695 maximumUniqueSubarray1695 = new MaximumUniqueSubarray1695();
    maximumUniqueSubarray1695.maximumUniqueSubarray(new int[]{4,2,4,5,6});
  }
  public int maximumUniqueSubarray(int[] nums) {
    int left = 0;
    int right = 0;
    int result = 0;
    int tempResult = 0;
    Map<Integer, Integer> visited = new HashMap<>();
    while (right < nums.length) {
      int rightValue = nums[right];
      tempResult += rightValue;
      int rightAppear = visited.getOrDefault(rightValue, 0);
      visited.put(rightValue, rightAppear+1);
      right++;
      while (visited.getOrDefault(rightValue, 0) > 1) {
        int leftValue = nums[left];
        int leftAppear = visited.get(leftValue);
        visited.put(leftValue, leftAppear-1);
        tempResult -= leftValue;
        left++;
      }
      result = Math.max(result, tempResult);
    }
    return result;
  }
}
