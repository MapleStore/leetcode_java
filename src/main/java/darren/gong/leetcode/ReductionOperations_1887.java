package darren.gong.leetcode;

import java.util.Arrays;

public class ReductionOperations_1887 {
  // 1887. 使数组元素相等的减少操作次数
  public static void main(String[] args) {
    ReductionOperations_1887 reductionOperations_1887 = new ReductionOperations_1887();
    reductionOperations_1887.reductionOperations(new int[]{1,1,2,2,3});
  }
  public int reductionOperations(int[] nums) {
    Arrays.sort(nums);
    int level = 0;
    int current = nums[0];
    int lastIndex = -1;
    int length = nums.length;
    int result = 0;
    for (int i = 0; i < length; i++) {
      if (nums[i] == current) {
        continue;
      }
      result += (i-lastIndex)*level;
      current = nums[i];
      level++;
      lastIndex = i;
    }
    result += (length-lastIndex)*level;
    return result;
  }
}
