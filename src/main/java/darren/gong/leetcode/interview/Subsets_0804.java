package darren.gong.leetcode.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets_0804 {
  // 面试题 08.04. 幂集
  private List<List<Integer>> result = new LinkedList<>();
  public List<List<Integer>> subsets(int[] nums) {
    for (int i = 0; i <= nums.length; i++) {
      backTracking(nums, new ArrayList<>(), i, 0);
    }
    return result;
  }
  private void backTracking(int[] nums, List<Integer> oneResult, int needNum, int fromIndex) {
    if (needNum == 0) {
      result.add(new ArrayList<>(oneResult));
      return;
    }
    for (int i = fromIndex; i < nums.length; i++) {
      oneResult.add(nums[i]);
      backTracking(nums, oneResult, needNum-1, i+1);
      oneResult.remove(oneResult.size()-1);
    }
  }
}
