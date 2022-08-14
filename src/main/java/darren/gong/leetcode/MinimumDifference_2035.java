package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class MinimumDifference_2035 {
  public static void main(String[] args) {
    MinimumDifference_2035 minimumDifference_2035 = new MinimumDifference_2035();
    minimumDifference_2035.minimumDifference(new int[]{3,9,7,3});
  }
  private int result = Integer.MAX_VALUE;
  private Map<Integer, TreeSet<Integer>> firstValues = new HashMap<>();
  public int minimumDifference(int[] nums) {
    int allSum = Arrays.stream(nums).sum();
    int length = nums.length;
    for (int i = 0; i <= length/2; i++) {
      firstValues.put(i, new TreeSet<>());
    }
    dfsFirst(nums, 0, 0, 0);
    dfsSecond(nums, length/2, 0, 0, allSum/2, allSum);
    return result;
  }
  private void dfsFirst(int[] nums, int index, int currentSum, int selectCount) {
    firstValues.get(selectCount).add(currentSum);
    for (int i = index; i < nums.length/2; i++) {
      dfsFirst(nums, i+1, currentSum+nums[i], selectCount+1);
    }
  }

  private void dfsSecond(int[] nums, int index, int currentSum, int selectCount, int half, int allSum) {
    Integer oppo = firstValues.get(nums.length/2-selectCount).floor(half-currentSum);
    result = oppo == null ? result : Math.min(result, Math.abs(allSum-oppo-currentSum-oppo-currentSum));
    oppo = firstValues.get(nums.length/2-selectCount).ceiling(half-currentSum);
    result = oppo == null ? result : Math.min(result, Math.abs(allSum-oppo-currentSum-oppo-currentSum));
    for (int i = index; i < nums.length; i++) {
      dfsSecond(nums, i+1, currentSum+nums[i], selectCount+1, half, allSum);
    }
  }

}
